package example.kotlin

import example.java.NullUtils

class KotlinNulls {
    fun isAdmin(username: String?) = username == "admin" // no more Yoda statements!

    fun passwordFromEnv(): String? {
        val passwordEnv : String? = System.getenv("PASSWORD")
//        println(passwordEnv.length)
        if (passwordEnv == null) {
//            val inspect: Int = NullUtils.inspectNonnull(passwordEnv) // returns Int, won't compile because has nonnull arg
            val unknownInspect: Int = NullUtils.unknownInspect(passwordEnv) // returns Int!
            val unknownInspect2: Int? = NullUtils.unknownInspect(passwordEnv) // returns Int!
            val safeInspect: Int = NullUtils.safeInspect(passwordEnv) // returns Int
            println("Inspected " + unknownInspect + safeInspect + unknownInspect2)
            return null
        }
        return passwordEnv
    }
}
