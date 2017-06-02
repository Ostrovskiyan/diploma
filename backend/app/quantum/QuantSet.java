package quantum;

import java.util.ArrayList;

public class QuantSet {

    private ArrayList<Quant> quants = new ArrayList<>();

    public void addQuant(Quant quant) {
        quants.add(quant);
    }

    public double[] vector() {
        int quantsSize = quants.size();
        int vectorLength = 2 << (quantsSize - 1);
        double[] vector = new double[vectorLength];
        Quant[] quantsArray = new Quant[quantsSize];
        quantsArray = quants.toArray(quantsArray);
        for (int i = 0; i < vectorLength; i++) {
            vector[i] = 1;
            for(int j = 0; j < quantsSize; j++) {
                double forMul;
                if((i & (vectorLength >> (j + 1))) > 0) {
                    forMul = quantsArray[j].getOne();
                } else {
                    forMul = quantsArray[j].getZero();
                }
                vector[i] *= forMul;
            }
        }
        return vector;
    }

}
