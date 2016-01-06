package com.ralspaugh.learning.scala

import com.ralspaugh.learning.scala.service.LunchTimeService

/**
 * LunchTime will take in three arguments (query, latitude, and longitude) and display a restaurant to eat at within range
 * of those parameters.
 *
 */
object LunchTime extends App {

  override def main (args: Array[String]) {
    val lunchSpotOption =  LunchTimeService.findTastyLunchSpot(args(0), args(1), args(2))
    if(lunchSpotOption.isDefined) {
      val lunchSpot = lunchSpotOption.get
      println(s"You can head down to ${lunchSpot.address} and get some tasty ${args(0)} at ${lunchSpot.name}")
    }
    else
      println( s"No results were found in the specified area for the query ${args(0)}" )
  }
}
