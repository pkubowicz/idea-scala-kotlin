package example.kotlin

interface KotlinButton {
    fun toggle(): Boolean
    fun caption(): String
    fun reset() {}
}

// classes are closed by default - remove open and Java won't compile
open class KotlinMenu {
    protected val buttons = mutableListOf<KotlinButton>()

    fun addButton(button: KotlinButton) {
        buttons.add(button)
    }

    open fun test() {
        println("${buttons.size} buttons")
    }
}
