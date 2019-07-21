package com.example.starter.`object`

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * carObject
 * brand
 * color
 * city
 */
data class Car(
  @JsonProperty("brand") val brand: String,
  @JsonProperty("color") val color : String,
  @JsonProperty("city") val city: String
)

