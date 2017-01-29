package example.scala

import example.java.OperatorProvider

class ScalaOperators(operatorProvider: OperatorProvider) {
  def sumDiagonal(): Int = {
    var sum = 0
    val list = operatorProvider.compute()
    for {
      i <- 0 until list.size()
      j <- 0 until list.get(i).size()
      if i == j
    } sum += list.get(i).get(j)
    sum
  }

  def twoComputationsTime(): java.time.Duration = {
//    operatorProvider.lastComputationTime() + operatorProvider.lastComputationTime() // does not compile
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
