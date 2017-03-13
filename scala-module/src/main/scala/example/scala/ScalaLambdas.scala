package example.scala

import java.util.function.Consumer

import example.java.LambdaConsumer

class ScalaLambdas(java: LambdaConsumer) {
  def passLambdasToJava(): Unit = {
    java.consumeInts(
      (i) => println(s"Scala prints $i"))
    val consumer1: Int => Unit = // Scala fun
      (i) => println("Scala prints $i")
//    java.consumeInts(consumer1) // won't compile
    val consumer2: Consumer[Integer] = // Java fun
      (i) => println("Scala prints $i")
    java.consumeInts(consumer2)

    val stringifierScala: Int => String =
      (i) => s"[$i]"
    val stringifier: Integer => String =
      (i) => s"[$i]"
//    java.printInts(stringifierScala) // won't compile
//    java.printInts(stringifier) // won't compile
    java.printInts((i) => s"[$i]")

    // another false suggestion from Idea:
    // 'new AbstractClass' cannot be removed
    var instance: LambdaConsumer.AbstractClass =
    new LambdaConsumer.AbstractClass {
      override def abstractMethod(): Unit = {
        utilityMethod()
      }
    }
    instance = () => { println("bar") }
  }




  def useConsumer(consumer: Int => Unit): Unit = {
    List(100, 200, 300).foreach((i) => consumer.apply(i))
  }

  def usePredicate(predicate: Int => Boolean): Unit = {
    predicate(50)
  }

  def usePredicateJavaVersion(predicate: Integer => Boolean): Unit = {
    predicate(50)
  }

  def useFunction2(fun2: (Int, String) => String) {
    fun2(10, "foo")
  }

  def useFunction2JavaVersion(fun2: (Integer, String) => String) {
    fun2(10, "foo")
  }

  private def testLambdas() {
    usePredicate((i) => i > 0)
    useFunction2((i, s) => "$i $s")
  }
}
