package example.scala

import javax.annotation.Nonnull

import example.java.{ChainElement, Named}

abstract class BaseStringChainElement[T]
  extends ChainElement[T] {
  override def handles(o: scala.Any): Boolean =
    o.isInstanceOf[String] && o.asInstanceOf[String].startsWith("Scala")
}



class ScalaPlainChainElement
  extends BaseStringChainElement[Int] {
  // Ctrl + O (Code -> Override Method) does not suggest handle()
  override def handle(o: scala.Any): Int =
    Integer2int(null)
}




class ScalaChainElement
  extends BaseStringChainElement[Integer] {
  @Nonnull // Int is not Integer!
  override def handle(o: scala.Any): Integer = {
    if (!o.isInstanceOf[String]) {
      return Integer2int(null) // breaks contract
    }
    // compiles but throws ClassCastException
//    o.asInstanceOf[String].last.asInstanceOf[Integer]
    o.asInstanceOf[String].last.toInt
  }

  override def describe(): String =
    "I don't need to override this but I will"
}


class ScalaLongChainElement // needs java.lang.Long
  extends BaseStringChainElement[Long] {
  override def handle(o: scala.Any) = 50L
}



case class ScalaCaseWithInterface(name: String,
                                  address: String,
                                  size: Int)
  extends Named {
  override def getName: String = name
}
