package com.example.domain

import spray.json.DefaultJsonProtocol

trait Animal

case class Person(name: String, kind: String = "person") extends Animal


