package com.example.starter

import io.vertx.core.Vertx
import io.vertx.ext.web.client.WebClient

import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(VertxExtension::class)
class TestMainVerticle {

//  @BeforeEach
//  fun deploy_verticle(vertx: Vertx, testContext: VertxTestContext) {
//    vertx.deployVerticle(App(), testContext.succeeding<String> { _ -> testContext.completeNow() })
//  }
//
//  @Test
//  fun verticle_deployed(vertx: Vertx, testContext: VertxTestContext) {
//    testContext.completeNow()
//  }

  /*@Test
  fun api_test(vertx: Vertx, testContext: VertxTestContext) {
    val client = WebClient.create(vertx)
    var user = json {
      obj(
        "brand" to "yamaha",
        "color" to "blue",
        "city" to "kh"
      )
    }

      client.post(9000,"localhost","/car/add").sendJson(user, { ar ->
        if (ar.succeeded()) {
          var response = ar.result()
          if(response.statusCode()==200)
            assert(true)
          else
            assert(false)

        } else {
          ar.cause().printStackTrace()
        }
      })

    testContext.completeNow()
  }*/


}
