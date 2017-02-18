package example.scala

class ScalaMoreNulls {
  def run(): Unit = {
    val nullable: List[Option[Int]] = List(
      Option(10), Option.empty, Option(20))
    var nonnull = nullable.filter((i) => i.isDefined)
      .map((i) => i.get)
    if (nonnull != List(10, 20)) {
      throw new IllegalStateException()
    }
  }
}
