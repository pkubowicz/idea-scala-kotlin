package example.kotlin

import example.java.LambdaConsumer
import java.util.function.Consumer

class KotlinLambdas(private val java: LambdaConsumer) {
    fun passLambdasToJava() {
        java.consumeInts { println("Kotlin prints $it") }
        val consumer1: (Int) -> Unit = // Kotlin fun
                { println("Kotlin2 prints $it") }
        java.consumeInts(consumer1)
        val consumer2: Consumer<Int> = // Java fun
                Consumer { println("Kotlin3 prints $it") }
        java.consumeInts(consumer2)

        val stringifier : (Int) -> String =
                { i -> "[$i]" }
        java.printInts(stringifier)
        java.printInts { i -> "[$i]" }

        var instance: LambdaConsumer.AbstractClass =
                object : LambdaConsumer.AbstractClass() {
            override fun abstractMethod() {
                utilityMethod()
                println("foo")
            }
        }
        // wont' compile - possible in Scala
//        instance = LambdaConsumer.AbstractClass { println("foo") }
    }

    fun useConsumer(consumer: (Int) -> Unit) {
        listOf(100, 200, 300).forEach(consumer)
    }

    fun usePredicate(predicate: (Int) -> Boolean) {
        predicate(50)
    }

    fun usePredicateNoJavaVersion(predicate: (Int) -> Boolean) {
        predicate(50)
    }

    fun useFunction2(fun2: (Int, String) -> String) {
        fun2(10, "foo")
    }

    fun useFunction2NoJavaVersion(fun2: (Int, String) -> String) {
        fun2(10, "foo")
    }

    private fun testLambdas() {
        usePredicate { i -> i > 0 }
        useFunction2 { i, s -> "$i $s" }
    }
}
