package example.runner;

import example.java.LambdaProvider;
import example.kotlin.KotlinLambdas;
import example.scala.ScalaLambdas;

class Lambdas {
    void run() {
        new ScalaLambdas(new LambdaProvider()).run();
        new KotlinLambdas(new LambdaProvider()).run();
    }
}
