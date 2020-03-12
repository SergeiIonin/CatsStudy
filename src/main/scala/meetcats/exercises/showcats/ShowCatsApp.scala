package meetcats.exercises.showcats

import typeclasses.exercises.printablelibrary.Cat

object ShowCatsApp extends App {

  import ShowInstances._
  import Showable.ShowableSyntax._

  val cat = Cat("Barsyk", 3, "gray")

  cat.print

}
