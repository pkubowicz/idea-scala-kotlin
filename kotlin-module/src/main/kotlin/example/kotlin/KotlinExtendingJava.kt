package example.kotlin

import example.java.ChainElement
import example.java.Named

abstract class BaseStringChainElement<T> :
        ChainElement<T> {
    override fun handles(o: Any) =
            // 'smart cast' - o is a String now
            o is String && o.startsWith("Kotlin")
}

class KotlinChainElement
    : BaseStringChainElement<Int>() {
    override fun handle(o: Any): Int {
        if (o !is String) {
//            return null // won't compile
            throw IllegalArgumentException("check with handles() first")
        }
//        return o.last() as Int // warns
        return o.last().toInt()
    }

    override fun describe() =
            "I don't need to override this but I will"
}

class KotlinShorterChainElement :
        BaseStringChainElement<Int>() {
    override fun handle(o: Any) =
            (o as String).last().toInt()
}

class KotlinLongChainElement :
BaseStringChainElement<Long>() {
    override fun handle(o: Any) = 50L
}

data class KotlinDataWithInterface(private val name: String,
                                   val address: String,
                                   val size: Int) :
        Named {
    override fun getName() = name
}
