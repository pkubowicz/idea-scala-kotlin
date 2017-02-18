package example.runner;

import example.java.LambdaConsumer;
import example.kotlin.KotlinLambdas;
import example.scala.ScalaLambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Lambdas implements Runnable {
    public void run() {
        ScalaLambdas scalaLambdas = new ScalaLambdas(new LambdaConsumer());
        scalaLambdas.passLambdasToJava();
        KotlinLambdas kotlinLambdas = new KotlinLambdas(new LambdaConsumer());
        kotlinLambdas.passLambdasToJava();

        passLambdasFromJava(scalaLambdas, kotlinLambdas);
    }

    private void passLambdasFromJava(ScalaLambdas scalaLambdas, KotlinLambdas kotlinLambdas) {
        Consumer<Integer> printer = System.err::println;

        System.err.println("Scala iterates over Java");
//        scalaLambdas.useConsumer(printer); // won't compile
//        scalaLambdas.useConsumer(System.err::println); // won't compile
        // won't compile without return null
        scalaLambdas.useConsumer(i -> { System.err.println(i); return null; });

        System.err.println("Kotlin iterates over Java");
//        kotlinLambdas.useConsumer(printer); // won't compile
//        kotlinLambdas.useConsumer(System.err::println); // won't compile
        kotlinLambdas.useConsumer(i -> { System.err.println(i) ; return null; });

        Predicate<Integer> greaterThanZero = (i) -> i > 0;

//        scalaLambdas.usePredicate(i -> i > 0); // won't compile - Int is not Integer
        scalaLambdas.usePredicateJavaVersion(i -> i > 0);
        // won't compile - functions are incompatible with Java
//        scalaLambdas.usePredicateJavaVersion(greaterThanZero);

        kotlinLambdas.usePredicate(i -> i > 0);
//        kotlinLambdas.usePredicate(greaterThanZero);

        BiFunction<Integer, String, String> format = (i1, s) -> Integer.toString(i1) + s;

        // won't compile - Int is not Integer
//        scalaLambdas.useFunction2((i, s) -> Integer.toString(i) + s);
        scalaLambdas.useFunction2JavaVersion((i, s) -> Integer.toString(i) + s);
        // won't compile - functions are incompatible with Java
//        scalaLambdas.useFunction2JavaVersion(format);

        kotlinLambdas.useFunction2((i, s) -> Integer.toString(i) + s);
//        kotlinLambdas.useFunction2(format);
    }
}
