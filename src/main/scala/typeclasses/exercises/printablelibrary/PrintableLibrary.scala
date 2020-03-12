package typeclasses.exercises.printablelibrary

object PrintableLibrary extends App {

  import PrintableInstances._
  import Printable.PrintableSyntax._

  val str = "some string"
  val int = 42
  val cat = Cat("Barsyk", 3, "gray")

  Printable.print(str)
  assert(Printable.format(str) == "some string")
  Printable.print(int)
  assert(Printable.format(int) == "42")
  Printable.print(cat)
  assert(Printable.format(cat) == "Barsyk is a 3 year-old gray cat.")

  cat.format
  cat.print
  //str.format
  int.print

}
