package com.example.starter.globalParam

import com.mongodb.reactivestreams.client.MongoClients

//mongo database set and collection set
const val database:String ="car"
const val carCollection :String ="carHourCounts"

/**
 * singleton , only one mongoClient instance in this service
 */
object mongoClient{
  var mongo = MongoClients.create()
}
