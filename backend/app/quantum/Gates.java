package quantum;

public class Gates {

    private static final double rootFromTwo = Math.sqrt(2);

    public static final double[][] H = new double[][]{
            {rootFromTwo, rootFromTwo},
            {rootFromTwo, -rootFromTwo}
    };

}
