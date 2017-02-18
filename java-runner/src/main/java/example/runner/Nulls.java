package example.runner;

import example.kotlin.KotlinNulls;
import example.scala.ScalaNulls;

class Nulls implements Runnable {
    public void run() {
        ScalaNulls scalaNulls = new ScalaNulls();
        KotlinNulls kotlinNulls = new KotlinNulls();
        System.err.println("Scala: is null admin? " + scalaNulls.isAdmin(null));
        System.err.println("Kotlin: is null admin? " + kotlinNulls.isAdmin(null));

        try {
            System.err.println(scalaNulls.passwordFromEnv());
        } catch (Exception e) {
            System.err.println("Expected exception from Scala");
            e.printStackTrace();
        }
        try {
            // IDE warns of NPE
            System.err.println(kotlinNulls.passwordFromEnv().length());
        } catch (Exception e) {
            System.err.println("Expected exception after calling Kotlin");
            e.printStackTrace();
        }
    }
}
