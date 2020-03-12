package typeclasses.enrichcaseclasses

case class Weather(temp: Int, wind: Int, humidity: Int, sky: String) {
  override def toString: String = s"the temp is $temp," +
    s"the wind is $wind," +
    s"the humidity is $humidity," +
    s"the sky is $sky"
}


