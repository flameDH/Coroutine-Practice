package com.example.starter.globalParam

import com.example.starter.common.HOST
import io.vertx.core.Vertx
import io.vertx.redis.RedisClient
import io.vertx.redis.RedisOptions
import io.vertx.redis.client.Redis

const val redisPort=7000;

object myRedis{
  private lateinit var client:RedisClient
  fun init(vertx: Vertx){
    client = RedisClient.create(vertx)
  }
  fun get():RedisClient{
    return client
  }
}





