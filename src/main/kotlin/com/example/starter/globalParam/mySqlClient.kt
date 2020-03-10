package com.example.starter.globalParam

import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.jdbc.JDBCClient
import io.vertx.ext.sql.SQLConnection
import io.vertx.kotlin.ext.sql.getConnectionAwait

object mySql{

  private lateinit var instance : JDBCClient

  fun init(vertx:Vertx){

    instance = JDBCClient.createShared(
      vertx, JsonObject()
    .put("url", "jdbc:mysql://127.0.0.1:3306/test")
      .put("driver_class", "com.mysql.cj.jdbc.Driver")
      .put("user", "root")
      .put("password", "freedom")
      .put("max_pool_size", 30)
    )

  }

  suspend fun get():SQLConnection{
    return instance.getConnectionAwait()
  }
}
