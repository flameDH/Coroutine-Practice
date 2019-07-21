package com.example.starter

import io.vertx.core.Vertx
import io.vertx.kotlin.core.deployVerticleAwait

/**
 * Ｓerver enter point
 */
suspend fun main() {
  val vertx = Vertx.vertx()
  try {
    vertx.deployVerticleAwait("com.example.starter.App")
    println("Application started")
  } catch (exception: Throwable) {
    println("Could not start application")
    exception.printStackTrace()
  }
}
