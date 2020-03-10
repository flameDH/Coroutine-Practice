package com.example.starter.api

import com.example.starter.`object`.Car
import com.example.starter.globalParam.myRedis
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.redis.getAwait
import io.vertx.kotlin.redis.incrAwait
import io.vertx.kotlin.redis.saddAwait
import io.vertx.kotlin.redis.setAwait

class redisTest {

  suspend fun test(ctx: RoutingContext){
    try {
      val carData = ctx.bodyAsJson.mapTo(Car::class.java)
      myRedis.get().saddAwait("brand", carData.brand)
      myRedis.get().incrAwait(carData.brand)
      val value = myRedis.get().getAwait(carData.brand)
      ctx.response().setStatusCode(200).end("{\"status\":200,\"value\":" + value + "}")
    }catch (e:Exception ){
      print(e)
      return ctx.response().setStatusCode(500).end("error")
    }
  }
}
