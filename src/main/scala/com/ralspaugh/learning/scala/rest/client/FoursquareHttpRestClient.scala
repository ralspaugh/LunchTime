package com.ralspaugh.learning.scala.rest.client

import java.io.IOException
import javax.xml.ws.http.HTTPException

import org.apache.commons.httpclient.{HttpStatus, HttpClient}
import org.apache.commons.httpclient.methods.GetMethod

object FoursquareHttpRestClient extends AuthenticatedClient {

  val httpClient = new HttpClient()

  def getTastyLunchSpot(query: String, longitude: String, latitude: String): String = {

    val url = s"https://api.foursquare.com/v2/venues/explore?ll=$longitude,$latitude&query=$query&limit=1&client_id=$clientId&client_secret=$clientSecret&v=20160105"

    val method = new GetMethod(url)

    try {
      if (httpClient.executeMethod(method) != HttpStatus.SC_OK) {
        println("Error executing http method: " + method.getStatusLine)
      }

      method.getResponseBodyAsString
    } catch {
      // TODO: Improve exception handling
      case e: HTTPException =>
        println(e.getMessage)
        null
      case e: IOException =>
        println(e.getMessage)
        null
    } finally {
      method.releaseConnection()
    }
  }
}
