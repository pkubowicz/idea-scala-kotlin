package example.kotlin

import example.java.LambdaConsumer
import java.util.function.Consumer

class KotlinLambdas(private val consumer: LambdaConsumer) {
    fun passLambdasToJava() {
        consumer.consumeInts { println("Kotlin prints $it") }
        val consumer1: (Int) -> Unit = { println("Kotlin2 prints $it") }
        this.consumer.consumeInts(consumer1)
        val consumer2: Consumer<Int> = Consumer { println("Kotlin3 prints $it") }

        val stringifier : (Int) -> String = { i -> "[$i]" }
        consumer.printInts(stringifier)
        consumer.printInts { i -> "[$i]" }

        var instance: LambdaConsumer.AbstractClass = object : LambdaConsumer.AbstractClass() {
            override fun abstractMethod() {
                utilityMethod()
                println("foo")
            }
        }
//        instance = LambdaConsumer.AbstractClass { println("foo") } // wont' compile - possible in Scala
    }

    fun useConsumer(consumer: (Int) -> Unit) {
        listOf(100, 200, 300).forEach(consumer)
    }

    fun usePredicate(predicate: (Int) -> Boolean) {
        predicate(50)
    }

    fun useFunction2(fun2: (Int, String) -> String) {
        fun2(10, "foo")
    }

    private fun testLambdas() {
        usePredicate { i -> i > 0 }
        useFunction2 { i, s -> "$i $s" }
    }
}
