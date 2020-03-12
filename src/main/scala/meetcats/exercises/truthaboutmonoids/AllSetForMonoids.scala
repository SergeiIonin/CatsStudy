package meetcats.exercises.truthaboutmonoids

import cats.{Monoid, Semigroup}

object AllSetForMonoids {

  implicit def setUnionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      def combine(setA: Set[A], setB: Set[A]) =
        setA union setB
      def empty = Set.empty[A]
  }

  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] =
    (a: Set[A], b: Set[A]) => a intersect b

  implicit def symDiffMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      def combine(a: Set[A], b: Set[A]): Set[A] =
        (a diff b) union (b diff a)
      def empty: Set[A] = Set.empty
    }


}
