package com.example

import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext.Implicits.global
import spray.http._
import MediaTypes._
import akka.actor.Actor
import spray.routing.Directive.pimpApply
import spray.routing.HttpService
import spray.json.{JsString, JsValue, RootJsonFormat, DefaultJsonProtocol}
import spray.httpx.SprayJsonSupport.sprayJsonMarshaller
import spray.httpx.SprayJsonSupport.sprayJsonUnmarshaller
import spray.routing.Directive.pimpApply
import spray.routing.HttpService
import spray.httpx.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import spray.routing.authentication.BasicAuth
import spray.routing.authentication.UserPass
import spray.routing.authentication.UserPassAuthenticator
import spray.routing.authentication.UserPassAuthenticator
import spray.routing.directives.AuthMagnet.fromContextAuthenticator
import spray.routing.directives.FieldDefMagnet.apply

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._

class ServiceActor extends Actor with Service {

  def actorRefFactory = context
  def receive = runRoute(myRoute)
}

trait Service extends HttpService {
  import com.example.domain.Person

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>tomcat</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }


}

