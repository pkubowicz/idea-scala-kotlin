package example.scala

object ScalaCollections {
  def oneTwoThree(): scala.collection.immutable.Seq[Int] = {
    val result = List(1, 2, 3)
//    result(1) = 500 // does dot compile - is not mutable
    result
  }

  def oneTwoThreeMutable(): scala.collection.mutable.Seq[Int] = {
    val result = scala.collection.mutable.ListBuffer(1, 2, 3)
    result(1) = 500
    result
  }
}
