package quantum;

public class Quant {

    public static final Quant ZERO = new Quant(1, 0);

    public static final Quant ONE = new Quant(0, 1);

    public static Quant zero() {
        return new Quant(1, 0);
    }

    public static Quant one() {
        return new Quant(0, 1);
    }

    private double zero;

    private double one;

    public Quant(double zero, double one) {
        this.zero = zero;
        this.one = one;
    }

    public double getZero() {
        return zero;
    }

    public void setZero(double zero) {
        this.zero = zero;
    }

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }
}
