package example.runner;

import example.kotlin.KotlinMoreNulls;
import example.scala.ScalaMoreNulls;

class MoreNulls implements Runnable {
    public void run() {
        new ScalaMoreNulls().run();
        new KotlinMoreNulls().run();
    }
}
