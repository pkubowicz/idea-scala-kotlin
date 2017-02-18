package example.kotlin

interface KotlinButton {
    fun toggle(): Boolean
    fun caption(): String
    fun reset() {} // default impl
}

// classes are closed by default
// remove open and Java won't compile
open class KotlinMenu {
    protected val buttons =
            mutableListOf<KotlinButton>()

    fun addButton(button: KotlinButton) {
        buttons += button
    }

    open fun test(i: Int): Int {
        println("${buttons.size} buttons")
        return buttons.size
    }
}
