package example.kotlin

import example.java.OperatorProvider

class KotlinOperators(private val operatorProvider: OperatorProvider) {
    fun sumDiagonal(): Int {
        var sum = 0
        val array: MutableList<MutableList<Int>> = operatorProvider.compute()
        for (i in array.indices) {
            for (j in array[i].indices) {
                if (i == j) {
                    sum += array[i][j]
                }
            }
        }
        return sum
    }

    fun twoComputationsTime(): java.time.Duration {
        return operatorProvider.lastComputationTime() + operatorProvider.lastComputationTime()
    }
}

data class KotlinTimeout(val millis: Int) {
    companion object {
        @JvmStatic
        fun run() {
            val timeout50 = KotlinTimeout(10) * 3 + KotlinTimeout(20)
            timeout50.millis == 50 || throw AssertionError("timeout is $timeout50")
        }
    }

    operator fun plus(other: KotlinTimeout) = KotlinTimeout(millis + other.millis)

    operator fun times(i: Int) = KotlinTimeout(millis * i)

    // no strange operators possible https://kotlinlang.org/docs/reference/operator-overloading.html
}


