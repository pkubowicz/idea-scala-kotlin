package example.kotlin

class KotlinVarargs {

    fun run() {
        System.err.println(java.lang.String.format(
                "in Kotlin: %s-%s", "foo", null))
        System.err.println(java.lang.String.format(
                "in Kotlin: string %s long %d",
                "foo", System.currentTimeMillis()))
        val time = arrayOf(12, 51, 46)
        System.err.println(java.lang.String.format(
                "in Kotlin: %d:%d:%d", *time))

        // * works in Kolin as well
        val nums = intArrayOf(1, 2, 4)
        format(*nums)
    }

    fun format(vararg a: Int): String =
            "sum " + a.sum()

    // makes no sense, just to have the same
    // number of methods as Scala
    inline fun formatInline(vararg a: Int) =
            "sum2 " + a.sum()
}
