package quantum;

public class Util {

    public static void main(String[] args) {
        double[] vector = new double[]{1, 2, -1};
        double[][] matrix = new double[][]{
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1}
        };
        printArray(Operations.applyGate(vector, matrix));
    }

    public static void printArray(double[] array) {
        for (double item : array) {
            System.out.print(item);
        }
        System.out.println();
    }

    public static void printDoubleArray(double[][] array) {
        for (double[] item : array) {
            printArray(item);
        }
    }

}
