package example.scala

import java.util.function.Consumer

import example.java.LambdaProvider
import example.java.LambdaProvider.AbstractClass

class ScalaLambdas(provider: LambdaProvider) {
  def run(): Unit = {
    println("Scala iterating over Java")
    val list = List(100, 200, 300)
    list.foreach((i) => provider.getPrinter.accept(i))
//    list.foreach(provider.getPrinter) // won't compile

    provider.consumeInts((i) => println(s"Scala prints $i"))
    val consumer: Int => Unit = (i) => println("Scala prints $i")
//    provider.consumeInts(consumer) // won't compile
    val consumer2: Consumer[Int] = (i) => println("Scala prints $i")

    // another false suggestion from Idea: 'new AbstractClass' cannot be removed
    var instance: LambdaProvider.AbstractClass = new AbstractClass {
      override def abstractMethod(): Unit = {
        utilityMethod()
      }
    }
    instance = () => { println("bar") }
  }
}
