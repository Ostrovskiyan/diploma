package quantum;

import java.util.function.Function;

public class Oracle {

    double[][] oracle;

    public Oracle(int size) {
        this(size, size);
    }

    public Oracle(int rows, int columns) {
        oracle = new double[rows][columns];
    }

    public double[][] getOracle() {
        return oracle;
    }

    public void setOracle(double[][] oracle) {
        this.oracle = oracle;
    }

}
