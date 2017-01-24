package example.kotlin

import example.java.NullUtils

class KotlinNulls {
    fun passwordFromEnv(): String? {
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

    fun isAdmin(username: String?) = username == "admin" // no more Yoda statements!
}
