package util;

public class PrimeGenerator {

    public static long getNextPrime(long start) {
        for (long res = start + 1; res < Long.MAX_VALUE; res++) {
            if (isPrime(res)) {
                return res;
            }
        }
        return 2;
    }

    private static boolean isPrime(long number) {
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
