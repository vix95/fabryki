package Benchmark;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class BenchmarkTools {

    public static void BenchmarkOpsTest(String name, long runMillis, int loop, int warmup, int repeat, Runnable runnable) {
        System.out.println("Running: " + name);

        int max = repeat + warmup;
        long average = 0L;

        for (int i = 0; i < max; i++) {
            long nops = 0;
            long duration = 0L;
            long start = System.currentTimeMillis();

            while (duration < runMillis) {
                for (int j = 0; j < loop; j++) {
                    runnable.run();
                    nops++;
                }

                duration = System.currentTimeMillis() - start;
            }

            long throughput = nops / duration;
            boolean benchRun = i >= warmup;

            if (benchRun) {
                average = average + throughput;
            }

            System.out.print(throughput + " ops/ms" + (!benchRun ? " (warmup) | " : " | "));
        }

        average = average / repeat;
        System.out.println("\n[ ~" + average + " ops/ms ]\n");
    }

    public static void BenchmarkTimeTest(String name, int loop, int repeat, Runnable runnable) {
        System.out.println("Running: " + name);
        List<Long> times = new ArrayList<>();

        for (int i = 0; i < repeat; i++) {
            long start = System.currentTimeMillis();

            for (int j = 0; j < loop; j++) {
                runnable.run();
            }

            long duration = System.currentTimeMillis() - start;
            times.add(duration);

            System.out.print(duration + " ms | ");
        }

        System.out.println("\n[ ~" + round(calculateAverage(times)) + " ms ]");
    }

    private static double calculateAverage(List<Long> marks) {
        Long sum = 0L;

        if (!marks.isEmpty()) {
            for (Long mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }

        return sum;
    }
}