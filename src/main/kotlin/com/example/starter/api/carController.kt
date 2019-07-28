package com.example.starter.api

import com.example.starter.`object`.Car
import io.vertx.ext.web.RoutingContext
import com.example.starter.model.*
import java.time.LocalDateTime

/**
 * controller
 * api /car/addCar enter point
 *
 * mapping data and call model to save data in mongo data
 *
 */
  suspend fun addCar(ctx: RoutingContext) {
      try {
        //mapping data
        val carData=ctx.bodyAsJson.mapTo(Car::class.java)
        //use awaitBlock?
        val time = getTime()

        //call model to save data
        addCar(carData, time)

        ctx.response().setStatusCode(200).end("{\"status\":200}")
      } catch (e: Exception) {
        println(e)
        ctx.response().setStatusCode(200).end("{\"status\": 400}")
      }

}

/**
 * get time func
 * get now datetime and set minute and second to zero
 */
private fun getTime(): LocalDateTime {
  val now = LocalDateTime.now()
  return LocalDateTime.of(now.year,now.month,now.dayOfMonth,now.hour,0,0)
}


