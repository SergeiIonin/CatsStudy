package meetcats.exercises.addingallthethings

import cats.Monoid
import cats.instances.int._
import cats.instances.double._
//import cats.instances.option._
import cats.instances.list._
import cats.syntax.semigroup._


object AddingAllTheThingsApp extends App {

/*  val list = (1 to 3).toList.map(Option(_))

  assert(add((1 to 3).toList.map(Option(_))) == Option(6))*/
  assert(add((1 to 3).toList) == 6)

  val order1 = Order(1.0, 3.0)
  val order2 = Order(4.5, 4.0)
  val order3 = Order(7.5, 2.0)

  val orders = List(order1, order2, order3)

  val addRes = add(orders)

  assert(add(orders) == Order(13.0, 9.0))

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(_ |+| _)

  implicit val monoid: Monoid[Order] = new Monoid[Order] {
    def combine(o1: Order, o2: Order) = {
      Order(o1.totalCost + o2.totalCost,
        o1.quantity + o2.quantity)
    }
    def empty = Order(0, 0)
  }

  case class Order(totalCost: Double, quantity: Double)

}
