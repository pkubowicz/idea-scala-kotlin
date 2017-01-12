package example.kotlin

import example.java.LambdaProvider
import java.util.function.Consumer

class KotlinLambdas(private val provider: LambdaProvider) {
    fun run() {
        println("Kotlin iterates using Java")
        val foo : List<Int> = listOf(100, 200, 300)
        var action: (Int) -> Unit = { provider.printer.accept(it) }
//        action = provider.printer // won't compile
        foo.forEach(action)

        provider.consumeInts { println("Kotlin prints $it") }
        val consumer: (Int) -> Unit = { println("Kotlin2 prints $it") }
        provider.consumeInts(consumer)
        val consumer2: Consumer<Int> = Consumer { println("Kotlin3 prints $it") }

        var instance: LambdaProvider.AbstractClass = object : LambdaProvider.AbstractClass() {
            override fun abstractMethod() {
                utilityMethod()
                println("foo")
            }
        }
//        instance = LambdaProvider.AbstractClass { println("foo") } // wont' compile - possible in Scala
    }
}
