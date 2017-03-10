package example.scala

import java.io.IOException

import example.java.NullUtils

object ScalaStatic {
  val VERSION = 1

  def describe(): String = "version " + VERSION +
    " using " + NullUtils.describe()

  def unused(): Unit = {} // no warning in IDE

  def throwSomething(): Unit = {
    doThrow()
  }

  private def doThrow(): Unit = {
    throw new IOException("fake checked exception")
  }
}

class ScalaStatic {

  // not needed in Kotlin
  // I can import from any object
  import ScalaStatic._

  def instanceRun(): Unit = { // unused but no warning in IDE
    describe()
    ScalaSingleton.describe() + VERSION
  }
}

object ScalaSingleton {
  val VERSION = 1

  def describe() = "Scala singleton"
}
