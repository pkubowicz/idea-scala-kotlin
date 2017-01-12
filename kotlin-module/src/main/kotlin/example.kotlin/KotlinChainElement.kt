package example.kotlin

import example.java.ChainElement

abstract class BaseStringChainElement<T> : ChainElement<T> {
    override fun handles(o: Any): Boolean {
        return o is String && o.startsWith("Kotlin")
    }
}

class KotlinChainElement : BaseStringChainElement<Int>() {
    override fun handle(o: Any): Int {
        if (o !is String) {
//            return null // won't compile
            throw IllegalArgumentException("check with handles() first")
        }
        // o is a String now
        assert(o[o.length - 1] == o.last())
        return o.last().toInt()
    }
}

class KotlinShorterChainElement : BaseStringChainElement<Int>() {
    override fun handle(o: Any) = (o as String).last().toInt()
}
