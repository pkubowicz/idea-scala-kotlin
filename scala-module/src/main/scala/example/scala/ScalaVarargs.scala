package example.scala

class ScalaVarargs {
  def run(): Unit = {
    System.err.println(java.lang.String.format("in Scala: %s-%s", "foo", null))
//    System.err.println(java.lang.String.format("in Scala: string %s long %d", "foo", System.currentTimeMillis())) // does not compile, works in Kotlin TODO why?
    val time = Array(12, 51, 46)
//    System.err.println(java.lang.String.format("in Scala: %d:%d:%d", time:_*)) // does not compile, works in Kotlin TODO does not compile

    // _* in Scala
    format(time:_*)
  }

  def format(a: Int*): String = "sum " + a.sum

  @annotation.varargs
  def formatAnnotated(a: Int*): String = "sum " + a.sum
}
