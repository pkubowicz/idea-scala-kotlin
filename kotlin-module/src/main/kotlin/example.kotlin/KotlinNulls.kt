package example.kotlin

import example.java.NullUtils

class KotlinTokenFactory {
    companion object {
        private val ADMIN = CredentialsData("admin", "admin")

        @JvmField
        val VERSION = 1

        @JvmStatic // not needed in Scala 1.12.1
        fun describe() : String = "version " + VERSION + NullUtils.VERSION

        fun describeKotlin() : String = "version " + VERSION

        fun unused() : String = "unused"
    }

    fun passwordFor(credentials: CredentialsData): String {
        if (credentials == ADMIN) {
            throw IllegalArgumentException("admin not allowed")
        }
        return credentials.name + "." + credentials.password
    }

    fun envPasswordFor(): String? {
        val passwordEnv : String? = System.getenv("PASSWORD")
//        println(passwordEnv.length)
        if (passwordEnv == null) {
//            val inspect: Int = NullUtils.inspectNonnull(passwordEnv) // returns Int, won't compile because has nonnull arg
            val unknownInspect: Int = NullUtils.unknownInspect(passwordEnv) // returns Int!
            val safeInspect: Int? = NullUtils.safeInspect(passwordEnv) // returns Int?
            println("Inspected " + unknownInspect + safeInspect)
            return null
        }
        return passwordEnv
    }

    fun isAdmin(credentials: CredentialsData?) = credentials == ADMIN // no more Yoda statements!

    fun unused2() : String = "unused2"

}

data class CredentialsData(val name: String, val password: String)
