package typeclasses

object RationalOrderingApp extends App {

  /**Exercises
   Implement an Ordering for Rational to order rationals from smallest to
largest. The following test case should pass.
assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
   * */


  assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
    List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))




}


