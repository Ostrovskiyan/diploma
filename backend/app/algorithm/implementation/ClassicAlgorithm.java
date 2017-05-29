package algorithm.implementation;

import algorithm.Algorithm;
import algorithm.Result;
import util.PrimeGenerator;

import java.math.BigInteger;

import static algorithm.ResultStatus.*;
import static util.BigIntegerOperations.log;
import static util.BigIntegerOperations.pow;

public class ClassicAlgorithm implements Algorithm {

    private final static BigInteger TWO = BigInteger.valueOf(2);
    private final static BigInteger ONE = BigInteger.ONE;
    private final static BigInteger ZERO = BigInteger.ZERO;

    @Override
    public Result factorize(BigInteger number) {
        long prime = 2;
        Result result;
        while (true) {
            result = factorize(prime, number);
            if (result.getResultStatus() == SUCCESS) {
                break;
            }
            prime = PrimeGenerator.getNextPrime(prime);
        }
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

        for (BigInteger exponent = BigInteger.valueOf(log(factorizedNumber, basisBI));
                exponent.compareTo(factorizedNumber) < 0;
                exponent = exponent.add(ONE)) {
            BigInteger moduleOfPoweredBasis = basisBI.modPow(exponent, factorizedNumber);
            if (!moduleOfPoweredBasis.equals(ONE)) {
                continue;
            }
            else {
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
                result.setPeriod(exponent.toString());
                result.setResultStatus(SUCCESS);
                return result;
            }
        }
        result.setResultStatus(CANNOT_BE_FACTORIZED);
        return result;
    }

}