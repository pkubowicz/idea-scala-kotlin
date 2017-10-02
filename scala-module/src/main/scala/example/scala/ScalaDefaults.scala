package example.scala

case class ScalaFile(name: String,
                     extension: String,
                     location: String,
                     executable: Boolean)











case class ScalaMutFile(var name: String,
                        var extension: String,
                        var location: String,
                        var executable: Boolean)




object ScalaDefaults {
  def createFile(name: String = "removeme",
                 extension: String = "",
                 location: String = "/tmp",
                 executable: Boolean = false): ScalaFile = {
    // no 'new'
    ScalaFile(name, extension, location, executable)
  }

  def use(): Unit = {
    createFile()
    createFile("named", "txt")
    createFile(location = "/var/tmp")




    println("Scala calls Java with named parameters: " +
      example.java.JavaManyParameters.createFile(
        location = "/tmp", name = "removeme",
        executable = false, extension = ".txt"))
  }
}
