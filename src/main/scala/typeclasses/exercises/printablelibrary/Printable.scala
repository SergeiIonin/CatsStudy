package typeclasses.exercises.printablelibrary

trait Printable[A] {
  def format(a: A): String
}

object PrintableInstances {
  implicit val intPrintable: Printable[Int] = {
    (a: Int) => a.toString
  }

  implicit val stringPrintable: Printable[String] = {
    (a: String) => a
  }

  implicit val catPrintable: Printable[Cat] = {
    (cat: Cat) => {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }
}

object Printable {

  implicit def format[A](a: A) (implicit p: Printable[A]) = {
    p.format(a)
  }

  implicit def print[A](a: A) (implicit p: Printable[A]) = {
    println(p.format(a))
  }

  object PrintableSyntax {
    implicit class PrintableOps[A](a: A) {
      implicit def format(implicit p: Printable[A]) = {
        p.format(a)
      }

      implicit def print(implicit p: Printable[A]) = {
        println(p.format(a))
      }
    }
  }

}


