package com.example.starter.globalParam

import com.mongodb.reactivestreams.client.MongoClients

const val database:String ="test"
const val carCollection :String ="carHourCounts"

/**
 * singleton , only one mongoClient instance in this service
 */
object mongoClient{
  var mongo = MongoClients.create()
}
