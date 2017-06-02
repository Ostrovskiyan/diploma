package quantum.shor;

import java.math.BigInteger;

public class Oracle {

    public static double[][] generateOracle(int n, int a, int mod) {
        long mask = 0x7FFF_FFFF_FFFF_FFFFL >> (63 - n);
        long halfMask = mask >> (n / 2);

        int columns = 2 * n;
        int rows = 1 << n;
        double[][] result = new double[rows][columns];
        for(int i = 0; i < rows; i++) {
            int fx = BigInteger.valueOf(a).modPow(BigInteger.valueOf(i), BigInteger.valueOf(mod)).intValue();

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(0x7FFF_FFFF_FFFF_FFFFL >> (63 - 4));
    }

}
