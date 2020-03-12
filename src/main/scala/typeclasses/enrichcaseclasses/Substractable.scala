package typeclasses.enrichcaseclasses

trait Substractable[T] {

  def +(t1: T, t2: T): T
  def -(t1: T, t2: T): T

}

object SubstractableInstances {

  implicit val intSubstractable: Substractable[Int] = new Substractable[Int] {
    override def +(t1: Int, t2: Int) = t1 + t2
    override def -(t1: Int, t2: Int) = t1 - t2
  }

  implicit val stringSubstractable: Substractable[String] = new Substractable[String] {
    override def +(t1: String, t2: String) = ""
    override def -(t1: String, t2: String) = if (t1 == t2) t1 else ""
  }

  implicit val weatherSubstractable: Substractable[Weather] = new Substractable[Weather] {
    override def +(w1: Weather, w2: Weather): Weather = Weather(Substractable.+(w1.temp, w2.temp),
      Substractable.+(w1.humidity, w2.humidity),
      Substractable.+(w1.wind, w2.wind),
      Substractable.+(w1.sky, w2.sky))

    override def -(w1: Weather, w2: Weather): Weather = Weather(Substractable.-(w1.temp, w2.temp),
      Substractable.-(w1.humidity, w2.humidity),
      Substractable.-(w1.wind, w2.wind),
      Substractable.-(w1.sky, w2.sky))
  }

}

object Substractable {

  def +[T](t1: T, t2: T)(implicit s: Substractable[T]) = {
    s.+(t1, t2)
  }

  def -[T](t1: T, t2: T)(implicit s: Substractable[T]) = {
    s.-(t1, t2)
  }

  object SubstractableSyntax {
    implicit class SubstractableOps[T](t: T) {
      implicit def +(implicit s: Substractable[T]) = {
        s.+(t1, t2)
      }

      implicit def print(implicit p: Printable[A]) = {
        println(p.format(a))
      }
    }
  }

}
