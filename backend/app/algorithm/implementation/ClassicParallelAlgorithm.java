package algorithm.implementation;

import algorithm.Algorithm;
import algorithm.Result;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static algorithm.ResultStatus.*;
import static tyrex.util.Configuration.console;
import static util.BigIntegerOperations.log;
import static util.BigIntegerOperations.pow;
import static util.Logger.console;

public class ClassicParallelAlgorithm implements Algorithm {

    private final static BigInteger TWO = BigInteger.valueOf(2);
    private final static BigInteger ONE = BigInteger.ONE;
    private final static BigInteger ZERO = BigInteger.ZERO;

    private final long[] PRIMES = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    @Override
    public Result factorize(String number) {
        final BigInteger factorizedNumber = new BigInteger(number);
        console("Factorize " + factorizedNumber, "Factorized number bit size " + factorizedNumber.bitLength());
        int i = 0;
        long startTime = System.currentTimeMillis();
        Result result;
        while (true) {
            result = factorize(PRIMES[i++], factorizedNumber);
            if (result.getResultStatus() == SUCCESS) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        console("Millis : " + time, "Second : " + time / 1000., "Minutes : " + time / 60_000.);
        return result;
    }

    private Result factorize(long basis, final BigInteger factorizedNumber) {
        Result result = new Result();
        result.setBasis(Long.toString(basis));
        BigInteger basisBI = BigInteger.valueOf(basis);

        // Check that basis is factor
        if (!basisBI.gcd(factorizedNumber).equals(ONE)) {
            result.setFirstFactor(basisBI.toString());
            result.setSecondFactor(factorizedNumber.divide(basisBI).toString());
            result.setResultStatus(SUCCESS);
            return result;
        }
        int coresCount = ForkJoinPool.getCommonPoolParallelism();

        BigInteger skipSteps = BigInteger.valueOf(log(factorizedNumber, basisBI));
        BigInteger step = BigInteger.valueOf(coresCount);
        Map<Integer, CompletableFuture> futureMap = new HashMap<>();

        for(int i = 0; i < coresCount; i++) {
            BigInteger exponent = skipSteps.add(BigInteger.valueOf(i));
            final int pNumber = i;
            futureMap.put(i, CompletableFuture.supplyAsync(() -> asyncCalculate(factorizedNumber, basisBI, exponent,
                    step, pNumber)));
        }

        return recursiveCall(futureMap);
    }

    private Result recursiveCall(Map<Integer, CompletableFuture> futureMap) {
        try {
            Collection<CompletableFuture> collection = futureMap.values();
            Result result = (Result) CompletableFuture.anyOf(collection.toArray(new CompletableFuture[collection.size()])).get();
            if (result.getResultStatus().equals(CANNOT_BE_FACTORIZED)) {
                futureMap.remove(result.getParallelNumber());
                return recursiveCall(futureMap);
            }
            return result;
        } catch (InterruptedException|ExecutionException e) {
            Result result = new Result();
            result.setResultStatus(CANNOT_BE_FACTORIZED);
            return result;
        }
    }

    private Result asyncCalculate(BigInteger factorizedNumber, BigInteger basisBI, BigInteger exponent, BigInteger step, int pNumber) {
        Result result = new Result();
        result.setParallelNumber(pNumber);
        result.setBasis(basisBI.toString());
        for (; exponent.compareTo(factorizedNumber) < 0; exponent = exponent.add(step)) {
            BigInteger moduleOfPoweredBasis = basisBI.modPow(exponent, factorizedNumber);
            if (!moduleOfPoweredBasis.equals(ONE)) {
                continue;
            } else {
                result.setPeriod(exponent.toString());
                if (!exponent.mod(TWO).equals(ZERO)) {
                    result.setResultStatus(INVALID_BASIS_PARAMETER);
                    return result;
                }

                BigInteger basisInPeriod = pow(basisBI, exponent.divide(TWO));
                BigInteger firstVariableForGcd = basisInPeriod.subtract(ONE);
                BigInteger secondVariableForGcd = basisInPeriod.add(ONE);

                BigInteger factor1 = firstVariableForGcd.gcd(factorizedNumber);
                BigInteger factor2 = secondVariableForGcd.gcd(factorizedNumber);

                if (factor1.equals(ONE) || factor2.equals(ONE)) {
                    result.setResultStatus(INVALID_BASIS_PARAMETER);
                    return result;
                }
                result.setFirstFactor(factor1.toString());
                result.setSecondFactor(factor2.toString());
                result.setResultStatus(SUCCESS);
                return result;
            }
        }
        result.setResultStatus(CANNOT_BE_FACTORIZED);
        return result;
    }

}