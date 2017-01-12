package example.scala

import java.time.Duration

import example.java.OperatorProvider

class ScalaOperators(operatorProvider: OperatorProvider) {
  def secondDiagonalElement(): Int = {
    val sum = 0
    val array = operatorProvider.compute()
    array.get(1).get(1) // TODO better
  }

  def twoComputationsTime(): Duration = {
//    operatorProvider.lastComputationTime() + operatorProvider.lastComputationTime()
    operatorProvider.lastComputationTime().plus(operatorProvider.lastComputationTime())
  }
}

case class ScalaTimeout(millis: Int) {
  def +(other:ScalaTimeout) = ScalaTimeout(millis + other.millis)

  def *(amount: Int) = ScalaTimeout(millis * amount)
}

object ScalaTimeout {
  def run(): Unit = {
    val timeout50 = ScalaTimeout(10) * 3 + ScalaTimeout(20)
    if (timeout50.millis != 50) {
      throw new AssertionError(s"timeout is $timeout50")
    }
  }
}
