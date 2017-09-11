package com.twitter.hello

import com.twitter.inject.TwitterModule

object HelloModule extends TwitterModule {
  override def configure(): Unit = {

    bind[HelloWorldService].to(classOf[HelloWorldServiceImpl])
  }
}
