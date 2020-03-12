package functors.exercises

import cats.instances.function._ // for Functor
import cats.syntax.functor._ // for map
import cats.Functor
import cats.instances.list._// for Functor
import cats.instances.option._

object BranchingOutWithFunctors extends App {

  implicit val treeFunctor: Functor[Tree] =
    new Functor[Tree] {
      def map[A, B](value: Tree[A])(func: A => B): Tree[B] =
        value match {
          case Leaf(value) => Leaf(func(value))
          case Branch(left, right) => Branch(map(left)(func), map(right)(func))
        }
    }
  
  val tree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
  val treeRes = Branch(Branch(Leaf(1), Leaf(4)), Leaf(9))
  assert(tree.map(x => x*x) == treeRes)

}

sealed trait Tree[+A]
final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

object Tree {
  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
    Branch(left, right)
  def leaf[A](value: A): Tree[A] =
    Leaf(value)
}
