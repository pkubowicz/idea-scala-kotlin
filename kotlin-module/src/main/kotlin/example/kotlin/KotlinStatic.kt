package example.kotlin

import example.java.NullUtils
import java.io.IOException

class KotlinStatic {
    fun instanceRun() {
        describeKotlin()
        KotlinSingleton.describe() + VERSION
    }

    companion object {
        const val VERSION = 1

        @JvmField // non-primitive, so cannot be const
        val OLD_VERSIONS = listOf(0.8, 0.9)

        val kotlinVersion = 2




        fun describeKotlin() : String = "version " + kotlinVersion +
                " using " + NullUtils.describe()

        @JvmStatic // not needed in Scala 1.12.1
        fun describe() : String = "version " + VERSION + NullUtils.VERSION

        fun unused() : String = "unused"



        @JvmStatic
//        @Throws(IOException::class)
        fun throwSomething() {
            doThrow()
        }

        private fun doThrow() {
            throw IOException("fake checked exception")
        }
    }
}



object KotlinSingleton {
    const val VERSION = 1

    fun describe() = "Kotlin singleton"
}
