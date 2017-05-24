package services;

import algorithm.Algorithm;
import algorithm.Result;
import algorithm.implementation.ClassicAlgorithm;
import dto.CalculateResult;

public class CalculateService {

    public static CalculateResult calculate(String number) {
        return new CalculateResult(number);
    }

    public static void main(String[] args) {
        final long sourceFactor1 = 157349;
        final long sourceFactor2 = 158363;
        Algorithm algorithm = new ClassicAlgorithm();
        Result result = algorithm.factorize(Long.toString(sourceFactor1 * sourceFactor2));
        System.out.println(result.getFirstFactor());
        System.out.println(result.getSecondFactor());
    }

}
