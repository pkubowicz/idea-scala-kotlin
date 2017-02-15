package example.kotlin

import example.java.NullUtils
import java.io.IOException

class KotlinStatic {
    companion object {
        const val VERSION = 1

        @JvmField // non-primitive, so cannot be const
        val OLD_VERSIONS = listOf(0.8, 0.9)

        val kotlinVersion = 2

        @JvmStatic // not needed in Scala 1.12.1
        fun describe() : String = "version " + VERSION + NullUtils.VERSION

        fun describeKotlin() : String = "version " + kotlinVersion + " using " + NullUtils.describe()

        fun unused() : String = "unused"

        @JvmStatic
        fun throwSomething() {
            doThrow()
        }

        private fun doThrow() {
            throw IOException("fake checked exception")
        }
    }

    fun instanceRun() {
        describeKotlin()
        KotlinSingleton.describe() + VERSION
    }
}

object KotlinSingleton {
    const val VERSION = 1

    fun describe() = "Kotlin singleton"
}