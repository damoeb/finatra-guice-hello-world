package com.twitter.hello

import javax.inject.Singleton

trait AService {
  def sayHello(name:String):String
}

@Singleton
class HelloService extends AService {
  override def sayHello(name: String): String = "Hello " + name
}
