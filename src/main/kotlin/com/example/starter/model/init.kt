package com.example.starter.model

import com.example.starter.globalParam.*
import com.mongodb.client.model.IndexOptions
import kotlinx.coroutines.reactive.awaitFirst
import org.bson.Document
import java.util.concurrent.TimeUnit

/**
 * init mongodb setting (index and TTL)
 */
suspend fun init(){

  //val mMongo = MongoClients.create()
  val mCollection = mongoClient.mongo.getDatabase(database).getCollection(carCollection)
  //create Index unique and create colllection

    mCollection.createIndex(Document("brand", 1).append("color", 1).append("city", 1)
      .append("hour", 1), IndexOptions().unique(true)).awaitFirst()

    //create Index expireAfterSeconds
    mCollection.createIndex(Document("hour", 1), IndexOptions().expireAfter(2592000, TimeUnit.SECONDS)).awaitFirst()

}
