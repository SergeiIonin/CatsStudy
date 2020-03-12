package meetcats
import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.kernel.Monoid
import cats.syntax.show._

object MeetCatsApp extends App {
  val showInt = Show.apply[Int]
  val showString = Show.apply[String]

  // object syntax
  showInt.show(123)
  showString.show("abc")

  // interface syntax
  123.show
  "abs".show

  // custom type class instances, just realize the show method of the type class
  import java.util.Date
  implicit val dateShow: Show[Date] =
    (date: Date) => s"${date.getTime}ms since the epoch."

  // using semigroup combine syntax |+|
  import cats.instances.string._ // for Monoid
  import cats.syntax.semigroup._ // for |+|

  val stringResult = "Hi " |+| "there" |+| Monoid[String].empty
  // stringResult: String = Hi there
  import cats.instances.int._ // for Monoid
  val intResult = 1 |+| 2 |+| Monoid[Int].empty


}


