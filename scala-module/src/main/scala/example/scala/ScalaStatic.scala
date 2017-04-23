package example.scala

import java.io.IOException

import example.java.NullUtils

class ScalaStatic {

  // not needed in Kotlin
  // I can import from any object
  import ScalaStatic._

  def instanceRun(): Unit = { // unused but no warning in IDE
    describe()
    ScalaSingleton.describe() + VERSION
  }
}

object ScalaStatic {
  val VERSION = 1




  def describe(): String = "version " + VERSION +
    " using " + NullUtils.describe()

  def unused(): Unit = {} // no warning in IDE



//  @throws(classOf[IOException])
  def throwSomething(): Unit = {
    doThrow()
  }

  private def doThrow(): Unit = {
    throw new IOException("fake checked exception")
  }
}



object ScalaSingleton {
  val VERSION = 1

  def describe() = "Scala singleton"
}
