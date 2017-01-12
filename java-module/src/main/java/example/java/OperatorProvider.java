package example.java;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class OperatorProvider {
    public List<List<Integer>> compute() {
        return Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
    }

    public Duration lastComputationTime() {
        return Duration.of(5, ChronoUnit.MILLIS);
    }
}
