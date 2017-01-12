package example.kotlin

object KotlinDefaults {
    @JvmStatic
    @JvmOverloads
    fun createFile(name: String = "removeme", extension: String = "", location: String = "/tmp", executable : Boolean = false): Any {
        return KotlinFile(name, extension, location, executable)
    }

    fun run() {
        createFile()
        createFile("named", "txt")
        createFile(location = "/var/tmp")

//        example.java.JavaManyParameters.createFile(location = "/var/tmp") // won't compile (yet)
    }

    private data class KotlinFile(val name: String, val extension: String, val location: String, val executable: Boolean)
}
