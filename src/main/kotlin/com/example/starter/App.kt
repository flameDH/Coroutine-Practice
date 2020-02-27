package com.example.starter

import com.example.starter.api.addCar
import com.example.starter.common.PORT
import com.example.starter.globalParam.myRedis
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.launch
import com.example.starter.model.init
import com.example.starter.routes.Routes
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer
import io.vertx.kotlin.coroutines.awaitResult

/**
 * server Main
 */
class App : CoroutineVerticle() {

  override suspend fun start() {

    //init mongo and create mongoClient Instance
    init()

    val vertx = Vertx.vertx()

    // Build Vert.x Web router
    val router= Routes(vertx).createRouter()
    myRedis.init(vertx)
    // Start the server adn set port
    awaitResult<HttpServer> {
      vertx.createHttpServer()
        .requestHandler(router::accept)
        .listen(PORT, it)
    }
  }

  /**
   * An extension method for simplifying coroutines usage with Vert.x Web routers
   */
//  fun Route.coroutineHandler(fn: suspend (RoutingContext) -> Unit) {
//    handler { ctx ->
//      launch(ctx.vertx().dispatcher()) {
//        try {
//          fn(ctx)
//        } catch (e: Exception) {
//          ctx.fail(e)
//        }
//      }
//    }
//  }

}
