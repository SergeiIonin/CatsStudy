package typeclasses.enrichcaseclasses

object WeatherApp extends App {

  import typeclasses.enrichcaseclasses.SubstractableInstances._
  import typeclasses.enrichcaseclasses.Substractable.SubstractableSyntax.SubstractableOps

  val w1 = Weather(25, 3, 78, "good")
  val w2 = Weather(26, 2, 73, "good")
  val w3 = Weather(22, 4, 75, "bad")

  //Substractable.+(w1, w2)
  val wRes1 = w1 - w2
  val wRes3 = w1 - w3

  println(wRes1)
  println(wRes3)

}
