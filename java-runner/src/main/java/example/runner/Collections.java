package example.runner;

import example.kotlin.KotlinCollections;
import example.scala.ScalaCollections;
import scala.collection.JavaConverters;
import scala.collection.convert.ImplicitConversionsToJava$;
import scala.collection.immutable.Seq;

import java.util.Iterator;
import java.util.List;

class Collections implements Runnable {
    public void run() {
        immutable();
        maps();
    }

    private void immutable() {
        // not easy to find a correct answer
        // http://stackoverflow.com/questions/17737631/convert-from-scala-collection-seqstring-to-java-util-liststring-in-java-code
        // top 2 answers are incorrect, first correct answer appeared on 2017-07-18
        Seq<Object> scalaSeq = ScalaCollections.oneTwoThree();
        scala.collection.immutable.List<Object> notJavaList = scalaSeq.toList();
        List<Object> javaList = JavaConverters.seqAsJavaListConverter(scalaSeq).asJava();
        // haven't found how to get List<Integer>
        System.err.println("Scala sequence " + javaList);
        // other problems: Scala Future

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


        ScalaCollections.oneTwoThreeMutable();
        Iterable<Integer> mutableKotlinIterable = KotlinCollections.INSTANCE.oneTwoThreeMutable();
    }



    private void maps() {
        ScalaCollections.analyseMap();
        KotlinCollections.INSTANCE.analyseMap();
    }
}
