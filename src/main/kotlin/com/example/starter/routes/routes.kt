package com.example.starter.routes

import com.example.starter.api.addCar
import com.example.starter.common.coroutineHandler
import io.vertx.core.Vertx
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler

class Routes(val vertx:Vertx){


  fun createRouter():Router{
    return Router.router(vertx).apply {
      route().handler(BodyHandler.create())
      post("/car/add").coroutineHandler{ addCar(it) }
    }
  }

}
