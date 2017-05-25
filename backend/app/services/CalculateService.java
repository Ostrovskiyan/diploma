package services;

import algorithm.Algorithm;
import algorithm.Result;
import algorithm.implementation.ClassicAlgorithm;

public class CalculateService {

    public static Result calculate(String number) {
        Algorithm algorithm = new ClassicAlgorithm();
        return algorithm.factorize(number);
    }

    public static void main(String[] args) {
//        final long sourceFactor1 = 65539;
//        final long sourceFactor2 = 65617;
//        Algorithm algorithm = new ClassicAlgorithm();
//        Result result = algorithm.factorize(Long.toString(sourceFactor1 * sourceFactor2));
//        System.out.println(result.getFirstFactor());
//        System.out.println(result.getSecondFactor());
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}
