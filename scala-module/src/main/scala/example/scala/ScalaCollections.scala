package example.scala

import java.util.Collections

import example.java.MapCalculator

object ScalaCollections {
  def oneTwoThree(): scala.collection.immutable.Seq[Int] = {
    val result = List(1, 2, 3)
    // does dot compile - is not mutable
//    result(1) = 500
    result
  }

  def oneTwoThreeMutable(): scala.collection.mutable.Seq[Int] = {
    val result = scala.collection.mutable.ListBuffer(1, 2, 3)
    result(1) = 500
    result
  }

  def analyseMap(): Unit = {
    val calculate = MapCalculator.calculate
    calculate.forEach((host, hostResults) => {
      hostResults.forEach((process, result) => {
        System.err.println(s"Scala $host:$process is ${result.getStatus} (checked in ${result.getTime}ms)")
      })
    })
  }

  def jdk8Methods(): Unit = {
    MapCalculator.calculate().computeIfAbsent("localhost", (host) => Collections.emptyMap())
  }
}
