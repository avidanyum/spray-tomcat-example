package com.example.util.json

import spray.json._
import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat
import com.example.domain.{Animal, Person}

object PersonSerializationImplicits {

  implicit val personFormat = jsonFormat2(Person)
  implicit object PersonJsonImplicits extends RootJsonFormat[Animal] {
    def write(a: Animal) = a match {
      case p: Person => p.toJson
    }

    def read(value: JsValue) = {
      value.asJsObject.fields("kind") match {
        case JsString("person") => value.convertTo[Person]
      }
    }
  }

}
