package com.ralspaugh.learning.scala

import com.ralspaugh.learning.scala.rest.client.FoursquareHttpRestClient

/**
 * LunchTime will take in three arguments (query, latitude, and longitude) and display a restaurant to eat at within range
 * of those parameters.
 *
 */
object LunchTime {

  def main (args: Array[String]) {
    // TODO: Do some response parsing and display the result in a more readable format
    println( FoursquareHttpRestClient.getTastyLunchSpot(args(0), args(1), args(2)) )
  }
}
