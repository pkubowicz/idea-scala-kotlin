package example.scala

import example.java.NullUtils

class ScalaNulls {
  def passwordFromEnv(): String = {
    val passwordEnv = System.getenv("PASSWORD")
    if (passwordEnv == null) {
      println("Calling method without required argument...")
      // missing argument, only a warning in compiler, nothing in IDE!!! () is null Unit
      println(NullUtils.inspectNonnull())
//      isAdmin() // but I cannot do such things in Scala
      println("...called!")

      // NPE from called Java here
      println(NullUtils.inspectNonnull(passwordEnv))
      // no warning although compiler can detect an NPE is guaranteed here!!!
      println(passwordEnv.length)
      return null
    }
    passwordEnv
  }

  def isAdmin(username: String): Boolean =
    username == "admin"
}
