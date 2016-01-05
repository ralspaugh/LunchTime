package com.ralspaugh.learning.scala

import com.ralspaugh.learning.scala.rest.client.FoursquareHttpRestClient

/**
 * Hello world!
 *
 */
object LunchTime {

  def main (args: Array[String]) {
    println( FoursquareHttpRestClient.getTastyLunchSpot(args(0), args(1), args(2)) )
  }
}
