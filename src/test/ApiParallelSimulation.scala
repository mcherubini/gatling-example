package test

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ApiParallelSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:3000")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36")

	val headers_0 = Map(
		"Content-Type" -> "text/html; charset=utf-8")



	val scn = scenario("ApiParallelSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
		)
		.exec(http("request_1")
			.get("/login")
			.headers(headers_0)
			.resources(
				http("request_2_parallel").get("/user").headers(headers_0),
				http("request async 2").get("/posts").headers(headers_0)
			)
		)

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}