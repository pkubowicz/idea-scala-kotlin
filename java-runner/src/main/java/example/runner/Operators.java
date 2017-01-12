package example.runner;

import example.java.OperatorProvider;
import example.kotlin.KotlinOperators;
import example.kotlin.KotlinTimeout;
import example.scala.ScalaOperators;
import example.scala.ScalaTimeout;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

class Operators {
    void run() {
        // Scala
        ScalaTimeout.run();
        ScalaTimeout scalaTimeout50 = new ScalaTimeout(10).$times(3).$plus(new ScalaTimeout(20));
        if (scalaTimeout50.millis() != 50) {
            throw new AssertionError("timeout is " + scalaTimeout50);
        }

        ScalaOperators scalaOperators = new ScalaOperators(new OperatorProvider());
        System.out.println(scalaOperators.secondDiagonalElement());
        Duration tenMillisFromScala = scalaOperators.twoComputationsTime();
        if (!tenMillisFromScala.equals(Duration.of(10, ChronoUnit.MILLIS))) {
            throw new AssertionError("duration is " + tenMillisFromScala);
        }

        // Kotlin
        KotlinTimeout.run();
        KotlinTimeout kotlinTimeout50 = new KotlinTimeout(10).times(3).plus(new KotlinTimeout(20));
        if (kotlinTimeout50.getMillis() != 50) {
            throw new AssertionError("timeout is " + kotlinTimeout50);
        }

        KotlinOperators kotlinOperators = new KotlinOperators(new OperatorProvider());
        Duration tenMillisFromKotlin = kotlinOperators.twoComputationsTime();
        if (!tenMillisFromKotlin.equals(Duration.of(10, ChronoUnit.MILLIS))) {
            throw new AssertionError("duration is " + tenMillisFromKotlin);
        }
        System.out.println(kotlinOperators.sumDiagonal());
    }
}
