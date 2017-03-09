package example.runner;

import example.kotlin.KotlinSingleton;
import example.kotlin.KotlinStatic;
import example.scala.ScalaSingleton;
import example.scala.ScalaStatic;

class Static implements Runnable {
    @Override
    public void run() {
        ScalaStatic.VERSION(); // this is a field in Kotlin
        System.err.println(KotlinStatic.VERSION);
//        System.err.println(KotlinStatic.kotlinVersion); // does not compile
        System.err.println(KotlinStatic.Companion.getKotlinVersion());
        System.err.println(KotlinStatic.OLD_VERSIONS);

        ScalaStatic.describe();
        KotlinStatic.Companion.describeKotlin();
//        KotlinStatic.describeKotlin(); // does not compile
        KotlinStatic.Companion.describe();
        KotlinStatic.describe();

        ScalaSingleton.VERSION();
        System.err.println(KotlinSingleton.VERSION);

        ScalaSingleton.describe();
        KotlinSingleton.INSTANCE.describe();

        try {
            ScalaStatic.throwSomething();
        } catch (Exception e) { // checked IOException is thrown but I cannot catch it
            // because throwSomething() does not declare it
            System.err.println("Expected exception");
            e.printStackTrace();
        }

        try {
            KotlinStatic.throwSomething();
        } catch (Exception e) { // the same problem with IOException
            System.err.println("Expected exception");
            e.printStackTrace();
        }
    }
}
