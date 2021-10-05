package org.yg

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://192.168.0.134:8081")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:92.0) Gecko/20100101 Firefox/92.0")

	val headers_0 = Map(
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")



	val scn = scenario("poxyTrainerTest")
		.repeat(3){exec(http("request_0")
			.get("/proxy-health/trainer-list")
			.headers(headers_0))}

//		.pause(6)
//		.exec(http("request_1")
//			.get("/proxy-health/trainer-list"))
//		.pause(7)
//		.exec(http("request_2")
//			.get("/proxy-health/trainer/54"))

	// 동시에 1000 명이 수행
	setUp(scn.inject(atOnceUsers(3))).protocols(httpProtocol)
}