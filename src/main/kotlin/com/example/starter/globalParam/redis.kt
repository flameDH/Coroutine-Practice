package com.example.starter.globalParam

import com.example.starter.common.HOST
import io.vertx.core.Vertx
import io.vertx.redis.RedisClient
import io.vertx.redis.RedisOptions

const val redisPort=7000;

class redisPro{
  companion object{
    @Volatile private var INSTANCE: redisPro? = null
    fun getInstance(vertx: Vertx){
      val options = RedisOptions().setHost(HOST).setPort(redisPort)
      val redisCli=RedisClient.create(vertx, options)
    }

  }
}



