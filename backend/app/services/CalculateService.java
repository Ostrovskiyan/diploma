package services;

import algorithm.Algorithm;
import algorithm.AlgorithmType;
import algorithm.Result;
import algorithm.implementation.ClassicAlgorithm;
import algorithm.implementation.ClassicParallelAlgorithm;

import java.math.BigInteger;

public class CalculateService {

    static {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", Integer.toString(Runtime.getRuntime().availableProcessors()));
    }

    public static Result calculate(String number, AlgorithmType type) {
        Algorithm algorithm;
        switch (type) {
            case CLASSIC:
                algorithm = new ClassicAlgorithm();
                break;
            case CLASSIC_PARALLEL:
                algorithm = new ClassicParallelAlgorithm();
                break;
            default:
                throw new RuntimeException("Invalid algorithm type");
        }

        long startTime = System.currentTimeMillis();
        Result result = algorithm.factorize(new BigInteger(number));
        long endTime = System.currentTimeMillis();
        result.setTime(Long.toString(endTime - startTime));
        return result;
    }

    public static void main(String[] args) {
        //        for(int i = 0; i < 10; i++) {
        Result r = calculate("9173503", AlgorithmType.CLASSIC);
        System.out.println(r.getFirstFactor());
        System.out.println(r.getSecondFactor());
        System.out.println(r.getPeriod());
        System.out.println(r.getBasis());
        System.out.println(r.getTime());
        //        }
        //        System.out.println("===========================");
        //        for(int i = 0; i < 10; i++) {
        //            Result r = calculate("9173503", AlgorithmType.CLASSIC_PARALLEL);
        //            System.out.println(r.getFirstFactor());
        //            System.out.println(r.getSecondFactor());
        //            System.out.println(r.getPeriod());
        //            System.out.println(r.getBasis());
        //            System.out.println(r.getTime());
        //        }
    }

}
