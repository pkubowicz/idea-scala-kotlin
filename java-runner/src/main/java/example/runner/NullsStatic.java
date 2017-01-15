package example.runner;

import example.kotlin.CredentialsData;
import example.kotlin.KotlinTokenFactory;
import example.kotlin.KotlinUser;
import example.scala.CredentialsCase;
import example.scala.ScalaUser;
import example.scala.ScalaTokenFactory;
import org.jetbrains.annotations.NotNull;

/**
 * handling nulls, static methods/objects/singletons, case classes, how stack traces look
 */
class NullsStatic {
    void run() {
        // Scala
        ScalaUser fakeScalaUser = new FakeScalaUser();
        if (fakeScalaUser.name() == null) {
            return;
        }
        System.err.println("Running Scala factory " + ScalaTokenFactory.describe());
        System.err.println("Running Scala factory v" + ScalaTokenFactory.VERSION()); // field in Kotlin
        ScalaTokenFactory scalaTokenFactory = new ScalaTokenFactory();
        System.err.println("Token for fake " + scalaTokenFactory.create(fakeScalaUser));
        try {
            System.err.println("Token from env " + scalaTokenFactory.createFromEnv(fakeScalaUser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Token for case " + scalaTokenFactory.create(new CredentialsCase("foo", "bar")));
        try {
            scalaTokenFactory.create(new CredentialsCase("admin", "example.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Scala: is admin admin? " + scalaTokenFactory.isAdmin(new CredentialsCase("admin", "example.com")));
        System.err.println("Scala: is null admin? " + scalaTokenFactory.isAdmin(null));

        // Kotlin
        KotlinUser fakeKotlinUser = new FakeKotlinUser();
        if (fakeKotlinUser.name() == null) {
            return;
        }
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

        System.err.println("Password length for fake " + kotlinTokenFactory.passwordFor(fakeKotlinUser).length());
        try {
            System.err.println("Password length for fake " + kotlinTokenFactory.envPasswordFor(fakeKotlinUser).length()); // NPE
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.err.println("Kotlin: is admin admin? " + kotlinTokenFactory.isAdmin(new CredentialsData("admin", "admin")));
        System.err.println("Kotlin: is null admin? " + kotlinTokenFactory.isAdmin(null));
    }

    private static class FakeKotlinUser implements KotlinUser {
        @NotNull
        @Override
        public String name() {
            return "fake";
        }
    }

    private static class FakeScalaUser implements ScalaUser {
        @Override
        public String name() {
            return "fake";
        }
    }
}
