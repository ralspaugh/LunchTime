package com.ralspaugh.learning.scala.rest.client

trait AuthenticatedClient {

  // These values should never be checked into source control, which is why this trait is git ignored.
  // Replace your local copy with the clientId and clientSecret provided to you from Foursquare.
  val clientId = "test"
  val clientSecret = ""
}
