package example.scala

import example.java.NullUtils

class ScalaNulls {
  def createFromEnv(): String = {
    val passwordEnv = System.getenv("PASSWORD")
    if (passwordEnv == null) {
      println("Calling method without required argument...")
      println(NullUtils.inspectNonnull()) // missing argument, only a warning in compiler, nothing in IDE!!! () is null Unit
//      isAdmin() // but I cannot do such things in Scala
      println("...called!")
      println(NullUtils.inspectNonnull(passwordEnv)) // NPE from called Java here
      println(passwordEnv.length) // no warning although compiler can detect an NPE is guaranteed here!!!
      return null
    }
    passwordEnv
  }

  def isAdmin(credentials: String): Boolean = credentials == "admin"
}
