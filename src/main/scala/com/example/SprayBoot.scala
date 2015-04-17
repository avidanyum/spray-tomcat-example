package com.example

import akka.actor.{Props, ActorSystem}
import spray.servlet.WebBoot
import akka.actor.ActorSystem
import akka.actor.Props

class SprayBoot extends WebBoot {

  val system = ActorSystem("actorsystem")
  val serviceActor = system.actorOf(Props[ServiceActor])

}