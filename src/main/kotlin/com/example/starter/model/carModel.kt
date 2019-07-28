package com.example.starter.model

import com.example.starter.`object`.Car
import com.example.starter.globalParam.*
import com.mongodb.client.model.UpdateOptions
import kotlinx.coroutines.reactive.awaitFirst
import org.bson.Document
import java.time.LocalDateTime


/**
 * addCar
 * save the data to mongodb (on duplicate key count=count+1)
 */
suspend fun addCar (carData :Car,time:LocalDateTime) {

  val collection =mongoClient.mongo.getDatabase(database).getCollection(carCollection)

  val doc=Document("brand", carData.brand).append("city", carData.city)
    .append("color", carData.color).append("time",time)

  collection.updateOne(doc,Document("\$inc", Document("count",1)),UpdateOptions().upsert(true)).awaitFirst()
}


