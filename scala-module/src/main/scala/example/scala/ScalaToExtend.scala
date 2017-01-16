package example.scala

import scala.collection.mutable.ListBuffer

trait ScalaButton {
  def toggle(): Boolean

  def caption(): String

  def reset(): Unit = {}
}

class ScalaMenu {
  protected val buttons = new ListBuffer[ScalaButton]()

  final def addButton(button: ScalaButton): Unit = buttons += button

  def test(): Unit = {
    println(s"${buttons.size} buttons")
  }
}
