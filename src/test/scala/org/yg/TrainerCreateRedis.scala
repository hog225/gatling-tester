package org.yg

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.json4s.DefaultFormats
import org.json4s.native.Json


class TrainerCreateRedis extends Simulation {

	val httpProtocol = http
		.baseUrl("http://192.168.0.134:8080")
		.inferHtmlResources()
		.acceptHeader("application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Gatling")
		.contentTypeHeader("application/json")

	val headers_0 = Map(
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")
//
	val roleSet = List("NORMAL", "MANAGER")
	val memberNameList = List("memberName ... 16", "memberN2 ... 16", "Tracer")
	val body = Map(
		"name" -> "name 1",
		"age"-> 35,
		"roleSet" -> roleSet,
		"memberNameList" -> memberNameList
	)

	var strBody = Json(DefaultFormats).write(body)
	println(strBody)



	val scn = scenario("proxyTrainerCreate")
		.during(20){exec(http("request_0")
			.post("/health/trainer-redis")
			.headers(headers_0)
			.body(StringBody(strBody))
			.check(status.is(200))
		)}


	//		.pause(6)
//		.exec(http("request_1")
//			.get("/proxy-health/trainer-list"))
//		.pause(7)
//		.exec(http("request_2")
//			.get("/proxy-health/trainer/54"))

	// 동시에 1000 명이 수행
	setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}