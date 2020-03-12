package typeclasses

object TypeClassesApp extends App {

  /**
   * the type class instance that will be implicitly provided  as a parameter
   * BUT only one implicit parameter should be in the scope to avoid ambiguity
   * */

  implicit val ordering = Ordering.fromLessThan[Int](_<_)

  /**
   * type class instances can be created in the following way
  val minOrdering = Ordering.fromLessThan[Int](_<_)
  val maxOrdering = Ordering.fromLessThan[Int](_>_)

   and then call
    println(list.sorted(maxOrdering))
   */

  val list = List(3, 1, 2)

  println(list.sorted)



}
