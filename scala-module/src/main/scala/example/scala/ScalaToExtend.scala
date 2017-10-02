package example.scala

import scala.collection.mutable.ListBuffer

trait ScalaButton {
  def toggle(): Boolean
  def caption(): String
  def reset(): Unit = {} // default impl
}


class ScalaMenu {
  protected val buttons =
    new ListBuffer[ScalaButton]()

  final def addButton(button: ScalaButton): Unit =
    buttons += button

  def test(i: Int): Int = {
    println(s"${buttons.size} buttons")
    buttons.size
  }
}
