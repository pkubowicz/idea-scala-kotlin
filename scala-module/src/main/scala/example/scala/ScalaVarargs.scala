package example.scala

class ScalaVarargs {
  def run(): Unit = {
    System.err.println(java.lang.String.format("in Scala: %s-%s", "foo", null))
    val time = Array(12, 51, 46)
//    System.err.println(java.lang.String.format("in Scala: %d:%d:%d", time:_*)) TODO does not compile

    // in Scala
    format(time:_*)
  }

  def format(a: Int*): String = "sum " + a.sum

  @annotation.varargs
  def formatAnnotated(a: Int*): String = "sum " + a.sum
}
