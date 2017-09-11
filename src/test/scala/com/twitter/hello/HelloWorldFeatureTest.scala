package com.twitter.hello

import com.codahale.metrics.MetricFilter
import com.google.inject.testing.fieldbinder.Bind
import com.twitter.finagle.http.Status._
import com.twitter.finagle.metrics.MetricsStatsReceiver
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.Mockito
import com.twitter.inject.server.FeatureTest

class HelloWorldFeatureTest extends FeatureTest with Mockito {

  override val server = new EmbeddedHttpServer(new HelloWorldServer)

//  @Bind val databaseClient = mock[SearchClient]

  override def afterEach() {
    MetricsStatsReceiver.metrics.removeMatching(MetricFilter.ALL)
  }

  "Server" should {
    "Say hi" in {
      server.httpGet(
        path = "/hi?name=Bob",
        andExpect = Ok,
        withBody = "Hello Bob")
    }
  }
}
