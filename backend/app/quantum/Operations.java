package quantum;

public class Operations {

    public static double[] applyGate(double[] vector, double[][] gate) {
        int vectorLength = vector.length;
        double[] result = new double[vectorLength];
        for(int i = 0; i < vectorLength; i++) {
            for(int j = 0; j < vectorLength; j++) {
                result[i] += gate[i][j] * vector[j];
            }
        }
        return result;
    }

}
