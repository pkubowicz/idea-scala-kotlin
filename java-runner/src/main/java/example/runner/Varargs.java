package example.runner;

import example.kotlin.KotlinVarargs;
import example.scala.ScalaVarargs;

class Varargs implements Runnable {
    public void run() {
        ScalaVarargs scalaVarargs = new ScalaVarargs();
        scalaVarargs.run();





//        System.err.println("Scala varargs are " + scalaVarargs.format(1, 2, 4)); // won't compile, annotation needed
        System.err.println("Scala varargs are " + scalaVarargs.formatAnnotated(1, 2, 4));
        System.err.println("Scala varargs are " + scalaVarargs.formatAnnotated(new int[]{1, 2, 4}));

        KotlinVarargs kotlinVarargs = new KotlinVarargs();
        kotlinVarargs.run();
        System.err.println("Kotlin varargs are " + kotlinVarargs.format(1, 2, 4));
        System.err.println("Kotlin varargs are " + kotlinVarargs.format(new int[]{1, 2, 4}));
    }
}
