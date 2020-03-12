package monads.exercises

import scala.language.higherKinds
import cats.Monad
import cats.instances.option._
import cats.instances.int._
import cats.syntax.functor._ // for map
import cats.syntax.flatMap._ // for flatMap

object GettingFuncyApp extends App {

}

trait Monad[F[_]] {

  def pure[A](a: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A, B](value: F[A])(func: A => B): F[B] =
    flatMap(value)(a => pure(func(a)))
}
