package typeclasses

final case class Rational(numerator: Int, denominator: Int)

object Rational {
  implicit val rationalOrdering = Ordering.fromLessThan[Rational]((x, y) => x.numerator*y.denominator < x.denominator*y.numerator)
}
