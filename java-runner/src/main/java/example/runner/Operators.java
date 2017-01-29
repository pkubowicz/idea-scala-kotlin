package example.runner;

import example.java.OperatorProvider;
import example.kotlin.KotlinOperators;
import example.kotlin.KotlinTimeout;
import example.scala.ScalaOperators;
import example.scala.ScalaTimeout;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

class Operators implements Runnable {
    public void run() {
        // Scala
        ScalaTimeout.run();
        ScalaTimeout scalaTimeout50 = new ScalaTimeout(10).$times(3).$plus(new ScalaTimeout(20));
        assertEqual(50, scalaTimeout50.millis());

        ScalaOperators scalaOperators = new ScalaOperators(new OperatorProvider());
        System.err.println("Scala sum diagonal " + scalaOperators.sumDiagonal());
        assertEqual(Duration.of(10, ChronoUnit.MILLIS), scalaOperators.twoComputationsTime());

        // Kotlin
        KotlinTimeout.run();
        KotlinTimeout kotlinTimeout50 = new KotlinTimeout(10).times(3).plus(new KotlinTimeout(20));
        assertEqual(50, kotlinTimeout50.getMillis());

        KotlinOperators kotlinOperators = new KotlinOperators(new OperatorProvider());
        System.err.println("Kotlin sum diagonal " + kotlinOperators.sumDiagonal());
        assertEqual(Duration.of(10, ChronoUnit.MILLIS), kotlinOperators.twoComputationsTime());
    }

    private static <T> void assertEqual(T expected, T actual) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual is " + actual);
        }
    }
}
