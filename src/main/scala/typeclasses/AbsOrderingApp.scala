package typeclasses

object AbsOrderingApp extends App {

  /**Exercises
   * Define an Ordering that orders Int s from lowest to highest by absolute value.
   * The following test cases should pass.
   * assert(List(-4, -1, 0, 2, 3).sorted(absOrdering) == List(0, -1, 2, 3, -4))
   * assert(List(-4, -3, -2, -1).sorted(absOrdering) == List(-1, -2, -3, -4))
   * */
  implicit val absOrdering = Ordering.fromLessThan[Int]((x, y) => x.abs < y.abs)

  assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
  assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))


}
