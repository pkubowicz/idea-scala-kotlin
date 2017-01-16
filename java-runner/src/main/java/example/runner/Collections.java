package example.runner;

import example.kotlin.KotlinCollections;
import example.scala.ScalaCollections;
import scala.collection.convert.ImplicitConversionsToJava$;
import scala.collection.immutable.Seq;

import java.util.Iterator;
import java.util.List;

class Collections {
    void run() {
        // http://stackoverflow.com/questions/17737631/convert-from-scala-collection-seqstring-to-java-util-liststring-in-java-code
        // OMG!!! no answer is correct
        Seq<Object> scalaSeq = ScalaCollections.oneTwoThree();
        scala.collection.immutable.List<Object> notJavaList = scalaSeq.toList();
        List<Object> javaList = ImplicitConversionsToJava$.MODULE$.seq$u0020AsJavaList(scalaSeq);
        System.err.println("Scala sequence " + javaList);

        // NB: returns a normal Java iterable, modifications fail in runtime
        Iterable<Integer> kotlinIterable = KotlinCollections.INSTANCE.oneTwoThree();
        Iterator<Integer> iteratorFromKotlin = kotlinIterable.iterator();
        iteratorFromKotlin.next();
        try {
            iteratorFromKotlin.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Kotlin iterable " + kotlinIterable);
    }
}
