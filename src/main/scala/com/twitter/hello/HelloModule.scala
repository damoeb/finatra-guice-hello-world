package com.twitter.hello

import com.twitter.finagle.stats.{LoadedStatsReceiver, StatsReceiver}
import com.twitter.inject.TwitterModule

object HelloModule extends TwitterModule {
  override def configure(): Unit = {

    bind[AService].to(classOf[HelloService])
//    bindSingleton[StatsReceiver].toInstance(LoadedStatsReceiver)
  }
}
