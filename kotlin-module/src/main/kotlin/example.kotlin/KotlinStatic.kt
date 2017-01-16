package example.kotlin

import example.java.NullUtils
import java.io.IOException

class KotlinStatic {
    companion object {
        const val VERSION = 1

        val kotlinVersion = 2

        @JvmStatic // not needed in Scala 1.12.1
        fun describe() : String = "version " + VERSION + NullUtils.VERSION

        @JvmStatic
        fun throwSomething() {
            doThrow()
        }

        private fun doThrow() {
            throw IOException("fake checked exception")
        }

        fun describeKotlin() : String = "version " + kotlinVersion + " using " + NullUtils.describe()

        fun unused() : String = "unused"
    }

    fun instanceRun() {
        describeKotlin()
        KotlinSingleton.describe()
    }
}

object KotlinSingleton {
    const val VERSION = 1

    fun describe() = "Kotlin singleton"
}
