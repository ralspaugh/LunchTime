package com.ralspaugh.learning.scala.service

import com.ralspaugh.learning.scala.domain.LunchSpot
import com.ralspaugh.learning.scala.rest.client.FoursquareHttpRestClient
import org.json4s._

object LunchTimeService {

  def findTastyLunchSpot(query: String, longitude: String, latitude: String): Option[LunchSpot] = {
    val response = FoursquareHttpRestClient.getTastyLunchSpot(query, longitude, latitude) \ "response"
    val groups = (response \ "groups")(0)
    val venue = (groups \ "items")(0) \ "venue"
    val venueName = venue \ "name"
    val venueAddress = venue \ "location" \ "address"

    if (venueName != JNothing && venueAddress != JNothing)
      Option(new LunchSpot(venueName.values.toString, venueAddress.values.toString))
    else
      Option.empty
  }
}
