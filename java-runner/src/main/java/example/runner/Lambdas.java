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
        Predicate<Integer> greaterThanZero = (i) -> i > 0;
        BiFunction<Integer, String, String> format = (i1, s) -> Integer.toString(i1) + s;

        System.err.println("Scala iterates over Java");
//        scalaLambdas.useConsumer(printer); // won't compile
//        scalaLambdas.useConsumer(System.err::println); // won't compile
        scalaLambdas.useConsumer(i -> { System.err.println(i); return null; });

//        scalaLambdas.usePredicate(i -> i > 0); // won't compile - Int is not Integer
        scalaLambdas.usePredicateJavaVersion(i -> i > 0);
//        scalaLambdas.usePredicateJavaVersion(greaterThanZero); // won't compile - functions are incompatible with Java

//        scalaLambdas.useFunction2((i, s) -> Integer.toString(i) + s); // won't compile - Int is not Integer
        scalaLambdas.useFunction2JavaVersion((i, s) -> Integer.toString(i) + s);
//        scalaLambdas.useFunction2JavaVersion(format); // won't compile - functions are incompatible with Java

        System.err.println("Kotlin iterates over Java");
//        kotlinLambdas.useConsumer(printer); // won't compile
//        kotlinLambdas.useConsumer(System.err::println); // won't compile
        kotlinLambdas.useConsumer(i -> { System.err.println(i) ; return null; }); // won't compile without return null

//        kotlinLambdas.usePredicate(greaterThanZero); // won't compile - functions are incompatible with Java
        kotlinLambdas.usePredicate(i -> i > 0);

//        kotlinLambdas.useFunction2(format); // won't compile - functions are incompatible with Java
        kotlinLambdas.useFunction2((i, s) -> Integer.toString(i) + s);
    }
}
