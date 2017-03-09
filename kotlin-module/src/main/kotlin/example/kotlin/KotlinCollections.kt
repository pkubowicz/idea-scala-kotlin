package example.kotlin

import example.java.MapCalculator
import java.util.*

object KotlinCollections {
    fun oneTwoThree(): Iterable<Int> {
        val result = listOf(1, 2, 3)
        // does not compile - is not mutable
//        result[1] = 100
        return result
    }

    fun oneTwoThreeMutable(): MutableIterable<Int> {
        val result = mutableListOf(1, 2, 3)
        result[1] = 100
        return result
    }

    fun analyseMap() {
        for ((host, hostResults) in MapCalculator.calculate()) {
            for ((process, result) in hostResults) {
                System.err.println("Kotlin $host:$process is ${result.status} (checked in ${result.time}ms)")
            }
        }
    }

    fun jdk8Methods() {
        MapCalculator.calculate().computeIfAbsent("localhost",
                { host -> Collections.emptyMap() })
    }
}
