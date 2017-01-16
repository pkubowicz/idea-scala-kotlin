package example.scala

import example.java.NullUtils

class ScalaTokenFactory {
  import ScalaTokenFactory._ // not needed in Kotlin

  def create(credentials: CredentialsCase): String = {
    if (credentials == admin) {
      throw new IllegalArgumentException("not allowed for admin") // no 'new' in Kotlin
    }
    credentials.name + "." + credentials.password
  }

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

  def isAdmin(credentials: CredentialsCase): Boolean = credentials == admin

  def unused2(): String = "unused2"
}

object ScalaTokenFactory {
  private def admin = CredentialsCase("admin", "example.com")
  def VERSION = 1
  def describe() : String = "version " + VERSION + NullUtils.VERSION
  def unused() : String = "unused" // Kotlin warns
  def unused2(foo: String) : String = "unused2"
}

case class CredentialsCase(name: String, password: String)
