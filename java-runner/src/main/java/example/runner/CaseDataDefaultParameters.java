package example.runner;

import example.kotlin.KotlinDefaults;
import example.kotlin.KotlinFile;
import example.kotlin.KotlinOpenFile;
import example.scala.ScalaDefaults;
import example.scala.ScalaFile;

class CaseDataDefaultParameters implements Runnable {
    public void run() {
        caseDataClasses();
        defaultParameters();
    }

    private void caseDataClasses() {
        ScalaFile scalaFile1 = new ScalaFile("n1", "e1", "l1", true);
        ScalaFile scalaFile2 = new ScalaFile("n1", "e1", "l1", true);
        System.err.println("Scala are equal " + scalaFile1.equals(scalaFile2));
        System.err.println("Scala hash codes " + (scalaFile1.hashCode() == scalaFile2.hashCode()));


        KotlinFile kotlinFile1 = new KotlinFile("n1", "e1", "l1", true);
        KotlinFile kotlinFile2 = new KotlinFile("n1", "e1", "l1", true);
        System.err.println("Kotlin are equal " + kotlinFile1.equals(kotlinFile2));
        System.err.println("Kotlin hash codes " + (kotlinFile1.hashCode() == kotlinFile2.hashCode()));
//        kotlinFile1.setName("foo"); // no setters
        new KotlinOpenFile("n2", "e2", "l2", false).setName("foo");
    }

    private void defaultParameters() {
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
