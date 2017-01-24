package example.runner;

import example.kotlin.KotlinNulls;
import example.scala.ScalaNulls;

class Nulls implements Runnable {
    public void run() {
        // Scala
        ScalaNulls scalaNulls = new ScalaNulls();
        System.err.println("Scala: is null admin? " + scalaNulls.isAdmin(null));
        try {
            System.err.println("Token from env " + scalaNulls.passwordFromEnv());
        } catch (Exception e) {
            System.err.println("Expected exception");
            e.printStackTrace();
        }

        KotlinNulls kotlinNulls = new KotlinNulls();
        System.err.println("Kotlin: is null admin? " + kotlinNulls.isAdmin(null));

        try {
            System.err.println("Password length for fake " + kotlinNulls.passwordFromEnv().length()); // IDE warns of NPE
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
