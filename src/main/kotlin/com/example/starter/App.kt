package com.example.starter

import com.example.starter.api.addCar
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.launch
import com.example.starter.model.init
/**
 * server Main
 */
class App : CoroutineVerticle() {

  override suspend fun start() {

    //init mongo and create mongoClient Instance
    init()

    // Build Vert.x Web router
    val router = Router.router(vertx)

    //process httpbody(like form data and json data)
    router.route().handler(BodyHandler.create())

    //TODO find way let router setting to single/mutiple file
    router.post("/car/add").coroutineHandler{ addCar(it) }

    // Start the server adn set port
    vertx.createHttpServer()
      .requestHandler(router)
      .listenAwait(config.getInteger("http.port", 9000))
  }

  /**
   * An extension method for simplifying coroutines usage with Vert.x Web routers
   */
  //TODO this part like akka , and I must to study this func
  fun Route.coroutineHandler(fn: suspend (RoutingContext) -> Unit) {
    handler { ctx ->
      launch(ctx.vertx().dispatcher()) {
        try {
          fn(ctx)
        } catch (e: Exception) {
          ctx.fail(e)
        }
      }
    }
  }

}
