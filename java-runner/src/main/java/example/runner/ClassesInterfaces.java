package example.runner;

import example.java.ChainElement;
import example.java.Named;
import example.kotlin.KotlinButton;
import example.kotlin.KotlinChainElement;
import example.kotlin.KotlinDataWithInterface;
import example.kotlin.KotlinMenu;
import example.kotlin.KotlinShorterChainElement;
import example.scala.ScalaButton;
import example.scala.ScalaChainElement;
import example.scala.ScalaMenu;
import example.scala.ScalaPlainChainElement;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

class ClassesInterfaces implements Runnable {
    public void run() {
        extendingJava();
        toExtend();
    }

    private void extendingJava() {
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

        Named[] named = new Named[]{new KotlinDataWithInterface("name", "addr", 2),
//                new example.scala.ScalaCaseWithInterface("name", "addr", 3)
        };
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

    private void toExtend() {
        ScalaMenu scalaMenu = new FakeScalaMenu();
        scalaMenu.addButton(new FakeScalaButton());
        scalaMenu.test();

        KotlinMenu kotlinMenu = new FakeKotlinMenu();
        KotlinButton button = new FakeKotlinButton();
        if (button.caption() == null) { // IDE understands this could not be null
            return;
        }
        kotlinMenu.addButton(button);
        kotlinMenu.test();
    }

    private static class FakeKotlinMenu extends KotlinMenu {
        @Override
        public void test() {
            getButtons().forEach(KotlinButton::reset);
        }

//        @Override public void addButton(KotlinButton button) {} // won't compile - is final
    }

    private static class FakeKotlinButton implements KotlinButton {
        @Override
        public boolean toggle() {
            return false;
        }

        @NotNull
        @Override
        public String caption() {
            return "dummy caption";
        }

        @Override
        public void reset() {
            // https://youtrack.jetbrains.com/issue/KT-4779 - this is not needed in Scala version of this class
            System.err.println("I shouldn't need to override this!");
        }
    }

    private static class FakeScalaMenu extends ScalaMenu {
        @Override
        public void test() {
            buttons().foreach(button -> {button.reset() ; return null; });
        }

        //        @Override public void addButton(ScalaButton button) {}
    }

    private static class FakeScalaButton implements ScalaButton {
        @Override
        public boolean toggle() {
            return false;
        }

        @Override
        public String caption() {
            return "dummy caption";
        }

//        @Override public void reset() { System.err.println("I can but I won't override this"); }
    }
}
