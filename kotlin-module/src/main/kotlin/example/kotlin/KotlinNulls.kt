package example.kotlin

import example.java.NullUtils

class KotlinNulls {
    fun isAdmin(username: String?) =
            username == "admin" // no more Yoda statements!

    fun passwordFromEnv(): String? {
        val passwordEnv : String? = System.getenv("PASSWORD")
//        println(passwordEnv.length)
        if (passwordEnv == null) {
            // won't compile because has nonnull arg
//            val inspect = NullUtils.inspectNonnull(passwordEnv)
            val unknownInspect: Int = //returns Int!
                    NullUtils.unknownInspect(passwordEnv)
            val unknownInspect2: Int? =
                    NullUtils.unknownInspect(passwordEnv)
            val safeInspect: Int = // returns Int
                    NullUtils.safeInspect(passwordEnv)
            println("Inspected " + unknownInspect + safeInspect + unknownInspect2)
            return null
        }
        return passwordEnv
    }
}
