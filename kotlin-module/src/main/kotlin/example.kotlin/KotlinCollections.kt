package example.kotlin

object KotlinCollections {
    fun oneTwoThree(): Iterable<Int> {
        val result = listOf(1, 2, 3)
//        result[1] = 100 // does dot compile - is not mutable
        return result
    }

    fun oneTwoThreeMutable(): MutableIterable<Int> {
        val result = mutableListOf(1, 2, 3)
        result[1] = 100
        return result
    }
}
