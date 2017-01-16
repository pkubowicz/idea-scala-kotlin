package example.runner;

import example.kotlin.CredentialsData;
import example.kotlin.KotlinTokenFactory;
import example.scala.CredentialsCase;
import example.scala.ScalaTokenFactory;

/**
 * handling nulls, static methods/objects/singletons, case classes, how stack traces look
 */
class NullsStatic implements Runnable {
    public void run() {
        // Scala
        System.err.println("Running Scala factory " + ScalaTokenFactory.describe());
        System.err.println("Running Scala factory v" + ScalaTokenFactory.VERSION()); // field in Kotlin
        ScalaTokenFactory scalaTokenFactory = new ScalaTokenFactory();
        try {
            System.err.println("Token from env " + scalaTokenFactory.createFromEnv());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Token for case " + scalaTokenFactory.create(new CredentialsCase("foo", "bar")));
        try {
            CredentialsCase credentials = new CredentialsCase("admin", "example.com");
            System.err.println("Checking for " + credentials.name());
            scalaTokenFactory.create(credentials);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Scala: is admin admin? " + scalaTokenFactory.isAdmin(new CredentialsCase("admin", "example.com")));
        System.err.println("Scala: is null admin? " + scalaTokenFactory.isAdmin(null));

//        System.err.println("Running Kotlin factory " + KotlinTokenFactory.describeKotlin()); // needs .Companion.
        System.err.println("Running Kotlin factory " + KotlinTokenFactory.describe());
        System.err.println("Running Kotlin factory v" + KotlinTokenFactory.VERSION);
        KotlinTokenFactory kotlinTokenFactory = new KotlinTokenFactory();

        try {
            CredentialsData credentials = new CredentialsData("admin", "admin");
            System.err.println("Checking for " + credentials.getName());
            kotlinTokenFactory.passwordFor(credentials);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.err.println("Password length for fake " + kotlinTokenFactory.envPasswordFor().length()); // IDE warns of NPE
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.err.println("Kotlin: is admin admin? " + kotlinTokenFactory.isAdmin(new CredentialsData("admin", "admin")));
        System.err.println("Kotlin: is null admin? " + kotlinTokenFactory.isAdmin(null));
    }
}
