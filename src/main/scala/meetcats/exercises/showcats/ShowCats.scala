package meetcats.exercises.showcats

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import typeclasses.exercises.printablelibrary.Cat


object ShowInstances {

  implicit val catPrintable = Show.show[Cat] {
    (cat: Cat) => {
      val name = cat.name.show
      val age = cat.age.show
      val color = cat.color.show
      s"$name is a $age year-old $color cat."
    }
  }
}

object Showable {

  implicit def format[A](a: A) (implicit s: Show[A]) = {
    s.show(a)
  }

  implicit def print[A](a: A) (implicit s: Show[A]) = {
    println(s.show(a))
  }

  object ShowableSyntax {
    implicit class ShowableOps[A](a: A) {
      implicit def format(implicit s: Show[A]) = {
        s.show(a)
      }

      implicit def print(implicit s: Show[A]) = {
        println(s.show(a))
      }
    }
  }

}
