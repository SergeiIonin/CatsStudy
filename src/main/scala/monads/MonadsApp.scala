package monads

import scala.language.higherKinds
import cats.Monad
import cats.instances.option._
import cats.instances.int._
import cats.instances.either._
import cats.instances.list._
import cats.syntax.functor._ // for map
import cats.syntax.flatMap._ // for flatMap
import cats.syntax.either._ // for flatMap
import cats.Id


object MonadsApp extends App {

  /**
   * Function that calculate params wrapped in a monad of a users choice*/
  def sumSquare2[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    a.flatMap(x => b.map(y => x*x + y*y))

  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x <- a
      y <- b
    } yield (x*x + y*y)
  // for Monad
  assert(sumSquare(Option(3), Option(4)) == Some(25))
  assert(sumSquare2(Option(3), Option(4)) == Some(25))
  // res8: Option[Int] = Some(25)
  assert(sumSquare(List(1, 2, 3), List(4, 5)) == List(17, 26, 20, 29, 25, 34))
  assert(sumSquare2(List(1, 2, 3), List(4, 5)) == List(17, 26, 20, 29, 25, 34))
  // res9: List[Int] = List(17, 26, 20, 29, 25, 34)

  /**
   * Example of using Id*/
  assert(sumSquare(3 : Id[Int], 4 : Id[Int]) == 25)

  /**
   * Either example*/

  def countPositive(nums: List[Int]) =
    nums.foldLeft(0.asRight[String]) { (accumulator, num) =>
      if(num > 0) {
        accumulator.map(_ + 1)
      } else {
        Left("Negative. Stopping!")
      }
    }
  assert(countPositive(List(1, 2, 3)) == Right(3))

}
