package typeclasses.enrichcaseclasses

object WeatherApp extends App {



  val w1 = Weather(25, 3, 78, "good")
  val w2 = Weather(26, 2, 73, "good")
  val w3 = Weather(22, 4, 75, "bad")

  w1 - w2


}
