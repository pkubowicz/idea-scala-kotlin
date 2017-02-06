package example.scala

case class ScalaFile(name: String, extension: String, location: String, executable: Boolean)

case class ScalaCaseClassCannotBeOpen(name: String, extension: String, location: String, executable: Boolean)

object ScalaDefaults {
  def createFile(name: String = "removeme", extension: String = "", location: String = "/tmp", executable: Boolean = false): ScalaFile = {
    ScalaFile(name, extension, location, executable)
  }

  def run(): Unit = {
    createFile()
    createFile("named", "txt")
    createFile(location = "/var/tmp")

//    example.java.JavaManyParameters.createFile(location = "/var/tmp") // wont' compile (yet)
  }
}
