package services;

import algorithm.Algorithm;
import algorithm.Result;
import algorithm.implementation.ClassicAlgorithm;
import algorithm.implementation.ClassicParallelAlgorithm;

public class CalculateService {

    public static Result calculate(String number) {
        Algorithm algorithm = new ClassicAlgorithm();
        return algorithm.factorize(number);
    }

    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
                Integer.toString(Runtime.getRuntime().availableProcessors()));
        final long sourceFactor1 = 7247;
        final long sourceFactor2 = 3719;
        Algorithm algorithm = new ClassicParallelAlgorithm();
        //        Algorithm algorithm = new ClassicAlgorithm();
        Result result = algorithm.factorize(Long.toString(sourceFactor1 * sourceFactor2));
        System.out.println(result.getFirstFactor());
        System.out.println(result.getSecondFactor());
        System.out.println(result.getPeriod());
        System.out.println(result.getBasis());
        //        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}
