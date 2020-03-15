package com.example.starter.common

private val DEFAULT_HOST = "localhost"
private val REDIS_HOST = "localhost"
private val MYSQL_HOST="localhost"
private val MONGO_HOST="mongo"

private val DEFAULT_PORT = 8080
private val REDIS_PORT="6379"
private val MYSQL_PORT="3306"
private val MONGO_PORT="27017"

public val MONGO_CONNECTION_STTRING="mongodb://$MONGO_HOST:$MONGO_PORT"

val PORT: Int
  get() {
    val systemPort = System.getenv("PORT")
    when (systemPort) {
      null -> return DEFAULT_PORT
      else -> return Integer.valueOf(systemPort)
    }
  }

val HOST: String
  get() {
    return System.getenv("HOST") ?: DEFAULT_HOST
  }
