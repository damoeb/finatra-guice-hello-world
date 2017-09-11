package com.twitter.hello

import com.google.inject.Inject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller


class HelloWorldController @Inject()(
  helloService: HelloService)
  extends Controller {

  get("/hi") { request: Request =>
    info("hi")
    helloService.sayHello(request.params.getOrElse("name", "unnamed"))
  }

  post("/hi") { helloRequest: HelloRequest =>
    "Hello " + helloRequest.name + " with id " + helloRequest.id
  }
}
