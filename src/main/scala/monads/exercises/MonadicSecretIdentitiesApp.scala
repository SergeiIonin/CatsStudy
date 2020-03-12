package monads.exercises
import cats.Id

object MonadicSecretIdentitiesApp extends App {

  def pure[A](value: A): Id[A] = value
  def map[A, B](initial: Id[A])(func: A => B): Id[B] =
    func(initial)
  def flatMap[A, B](initial: Id[A])(func: A => Id[B]): Id[B] =
    func(initial)

}
