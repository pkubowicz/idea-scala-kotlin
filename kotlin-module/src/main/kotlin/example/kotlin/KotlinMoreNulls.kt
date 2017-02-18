package example.kotlin

class KotlinMoreNulls {
    fun run() {
        // type is List<Int?>
        val nullable = listOf(10, null, 20)
        val nonnull : List<Int> = nullable
                .filterNotNull()
        nonnull == listOf(10, 20) || throw IllegalStateException()
    }
}
