package functors

import cats.instances.function._ // for Functor
import cats.syntax.functor._ // for map
import cats.Functor
import cats.instances.list._// for Functor
import cats.instances.option._

object Functors extends App {

  val func =
    ((x: Int) => x.toDouble).
      map(x => x + 1).
      map(x => x * 2).
      map(x => x + "!")

  print(func(123))

  //////

  val func1 = ((x: Int) => x.toDouble)
  val func2: Double => Double = (x: Double) => x + 1

  println(func1.map(func2)(123))

  /**
   * Working with Functor class
   * */
  val list1 = List(1, 2, 3)
  // list1: List[Int] = List(1, 2, 3)
  val list2 = Functor[List].map(list1)(_ * 2)
  // list2: List[Int] = List(2, 4, 6)
  val option1 = Option(123)
  // option1: Option[Int] = Some(123)
  val option2 = Functor[Option].map(option1)(_.toString)
  println(option2)

  /**
   * Using lift
   * */
  val plusOne = (x: Int) => x + 1
  val liftedPlusOne = Functor[Option].lift(plusOne)
  val someRes = liftedPlusOne(Some(2))
  println(someRes)

  /**
   * Using interface syntax of Functor
   * */

  val fun1 = (x: Int) => x + 1
  val fun2 = (x: Int) => x*3
  val fun3 = (x: Int) => x*x

  val funComposed = fun1.map(fun2).map(fun3)
  println(funComposed(2))


  /**
   * Abstraction over container type*/
  def doMath[F[_]](start: F[Int])
                  (implicit functor: Functor[F]): F[Int] =
    start.map(n => n + 1 * 2)

  assert(doMath(Option(3)) == Some(5))
  assert(doMath(List(1,2,3)) == List(3,4,5))



}
