package example.java;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaConsumer {
    public void consumeInts(Consumer<Integer> consumer) {
        Arrays.asList(1500, 100, 900).forEach(consumer);
    }

    public void printInts(Function<Integer, String> stringifier) {
        Arrays.asList(1500, 100, 900).forEach(i -> System.err.printf("%d becomes %s\n", i, stringifier.apply(i)));
    }

    public static abstract class AbstractClass {
        public abstract void abstractMethod();

        protected void utilityMethod() {
        }
    }
}
