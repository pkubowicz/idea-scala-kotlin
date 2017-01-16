package example.runner;

import example.kotlin.KotlinDefaults;
import example.scala.ScalaDefaults;

class DefaultParameters implements Runnable {
    public void run() {
        System.err.println("Scala");
        System.err.println(ScalaDefaults.createFile("other-name", "", "/tmp", false));
        System.err.println(ScalaDefaults.createFile$default$2()); // WTF? Does not return anything!

        System.err.println("Kotlin");
        System.err.println(KotlinDefaults.createFile());
        System.err.println(KotlinDefaults.createFile("other-name"));
        System.err.println(KotlinDefaults.createFile("other-name", "other-ext"));
        System.err.println(KotlinDefaults.createFile("other-name", "other-ext", "/var/tmp"));
    }
}
