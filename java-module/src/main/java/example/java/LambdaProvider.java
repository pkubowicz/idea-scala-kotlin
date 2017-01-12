package example.java;

import java.util.Arrays;
import java.util.function.Consumer;

public class LambdaProvider {
    public Consumer<Integer> getPrinter() {
        return System.err::println;
    }

    public void consumeInts(Consumer<Integer> consumer) {
        Arrays.asList(1500, 100, 900).forEach(consumer);
    }

    public static abstract class AbstractClass {
        public abstract void abstractMethod();

        protected void utilityMethod() {
        }
    }
}
