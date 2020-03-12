package typeclasses.jsonwriter

object JsonWriterApp extends App {

  /**
   * This is an example of using the interface object: the relevant implicit
   * object (writer) is supplied to the calling method toJson of the Json object
   */

  import JsonWriterInstances._

  val serega = Person("Serega", "gmail@serega.com")
  val json = Json.toJson(serega)
  println(json)

  /**
   * This is an example of using the interface syntax: the JsonSyntax have an
   * implicit class with the method toJson, that requires impl. writer to be supplied
   */

  import Json.JsonSyntax._

  serega.toJson
  println(json)
  val x = implicitly[JsonWriter[String]]
  println(x)

}

final case class Person(name: String, email: String)

object JsonWriterInstances {

  implicit val stringWriter: JsonWriter[String] =
   new JsonWriter[String] {
     def write(s: String): Json = JsString(s)
   }

  implicit val personWriter: JsonWriter[Person] =
   new JsonWriter[Person] {
     def write(p: Person): Json =
       JsObject(Map(
         "name" -> JsString(p.name),
         "email" -> JsString(p.email)
       ))
   }

}
