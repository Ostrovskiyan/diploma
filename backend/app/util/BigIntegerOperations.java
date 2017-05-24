package util;

import java.math.BigInteger;

public class BigIntegerOperations {

    private final static BigInteger TWO = BigInteger.valueOf(2);
    private final static BigInteger ONE = BigInteger.ONE;
    private final static BigInteger ZERO = BigInteger.ZERO;

    public static BigInteger sqrt(BigInteger forSqrt) {
        BigInteger result = forSqrt;
        BigInteger div = forSqrt;
        if(forSqrt.compareTo(BigInteger.ZERO) < 0) {
            return BigInteger.ZERO;
        }

        while(true) {
            div = forSqrt.divide(div).add(div).divide(TWO);
            if(result.compareTo(div) > 0) {
                result = div;
            } else {
                return result;
            }
        }
    }

    public static BigInteger pow(BigInteger number, BigInteger power) {
        if(power.equals(ONE)) {
            return number;
        }
        BigInteger nextPower = TWO;
        BigInteger result = number;
        do {
            result = result.multiply(result);
            nextPower = nextPower.multiply(TWO);
        } while (nextPower.compareTo(power) <= 0);

        BigInteger powerDiff = power.subtract(nextPower.divide(TWO));
        if(powerDiff.equals(ZERO)) {
            return result;
        } else {
            return result.multiply(pow(number, powerDiff));
        }
    }

}
