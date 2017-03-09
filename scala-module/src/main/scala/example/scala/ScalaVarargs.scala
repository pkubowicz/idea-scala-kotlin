package example.scala

class ScalaVarargs {
  def run(): Unit = {
    System.err.println(java.lang.String.format(
      "in Scala: %s-%s", "foo", null))
    // does not compile, works in Kotlin, IDE says ok
//    System.err.println(java.lang.String.format(
//      "in Scala: string %s long %d",
//      "foo", System.currentTimeMillis()))
    val time = Array(12, 51, 46)
    // does not compile, works in Kotlin
//    System.err.println(java.lang.String.format(
//      "in Scala: %d:%d:%d", time:_*))
    // compiles, fails in runtime
//    System.err.println(java.lang.String.format(
//      "in Scala: %d:%d:%d", time))

    // _* in Scala
    format(time:_*)
  }

  def format(a: Int*): String =
    "sum " + a.sum

  @annotation.varargs
  def formatAnnotated(a: Int*): String =
    "sum2 " + a.sum
}
