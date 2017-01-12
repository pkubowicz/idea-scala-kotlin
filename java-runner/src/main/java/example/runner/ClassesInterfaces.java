package example.runner;

import example.java.ChainElement;
import example.kotlin.KotlinChainElement;
import example.kotlin.KotlinShorterChainElement;
import example.scala.ScalaPlainChainElement;
import example.scala.ScalaChainElement;

import java.util.Arrays;
import java.util.List;

class ClassesInterfaces {
    void run() {
        // does not compile
//        ChainElement<Integer> plainScalaChainElement = new example.scala.PlainScalaChainElement();

        List<ChainElement<Integer>> responsibilityChain = Arrays.asList(
                new KotlinChainElement(),
                new ScalaChainElement()
        );

        handle(responsibilityChain, "Java:A");
        handle(responsibilityChain, "Kotlin:B");
        handle(responsibilityChain, "Scala:C");

        try {
            new KotlinShorterChainElement().handle(100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("PlainScalaChainElement: " + new ScalaPlainChainElement().handle("foo"));
    }

    private static void handle(List<ChainElement<Integer>> responsibilityChain, Object object) {
        for (ChainElement<Integer> chainElement : responsibilityChain) {
            if (chainElement.handles(object)) {
                System.err.printf("%s handled as %s by %s\n", object, chainElement.handle(object), chainElement);
                return;
            }
        }
        System.err.println("Not handled: " + object);
    }
}
