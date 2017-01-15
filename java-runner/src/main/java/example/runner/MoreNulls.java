package example.runner;

import example.kotlin.KotlinMoreNulls;
import example.scala.ScalaMoreNulls;

class MoreNulls {
    void run() {
        new ScalaMoreNulls().run();
        new KotlinMoreNulls().run();
    }
}
