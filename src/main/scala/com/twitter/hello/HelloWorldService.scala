package com.twitter.hello

import javax.inject.Singleton

trait HelloWorldService {
  def sayHello(name:String):String
}

@Singleton
class HelloWorldServiceImpl extends HelloWorldService {
  override def sayHello(name: String): String = "Hello " + name
}
