import sbt._

object Dependencies {
  object Versions {
    val cats           = "2.6.1"
    val catsEffect     = "3.1.1"
    val http4s         = "1.0.0-M21"
    val scalaTest      = "3.2.5"
    val contextApplied = "0.1.4"
    val circe          = "0.14.1"
    val log4cats       = "2.0.1"
    val logback        = "1.2.3"
    val gatling        = "3.5.1"
    val canoe          = "0.5.1"
    val ciris          = "2.0.1"
    val refined        = "0.9.23"
  }

  object Libraries {
    def http4s(artifact: String): ModuleID   = "org.http4s"    %% artifact % Versions.http4s
    def circe(artifact: String): ModuleID    = "io.circe"      %% artifact % Versions.circe
    def log4cats(artifact: String): ModuleID = "org.typelevel" %% artifact % Versions.log4cats
    def ciris(artifact: String): ModuleID    = "is.cir"        %% artifact % Versions.ciris

    val cats       = "org.typelevel" %% "cats-core"   % Versions.cats
    val catsEffect = "org.typelevel" %% "cats-effect" % Versions.catsEffect

    val http4sDsl    = http4s("http4s-dsl")
    val http4sServer = http4s("http4s-blaze-server")
    val http4sClient = http4s("http4s-blaze-client")
    val http4sCirce  = http4s("http4s-circe")

    val log4catsSlf4j = log4cats("log4cats-slf4j")
    val logback       = "ch.qos.logback" % "logback-classic" % Versions.logback

    val circeGeneric = circe("circe-generic")
    val cirisCore    = ciris("ciris")
    val cirisRefined = ciris("ciris-refined")
    val scalaTest    = "org.scalatest"  %% "scalatest" % Versions.scalaTest
    val canoe        = "org.augustjune" %% "canoe"     % Versions.canoe
    val refined      = "eu.timepit"     %% "refined"   % Versions.refined

    // format: off
    val gatlingHighcharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % Versions.gatling % "it"
    val gatling           = "io.gatling"            % "gatling-test-framework"    % Versions.gatling % "it"
    // format: on

    val contextApplied = "org.augustjune" %% "context-applied" % Versions.contextApplied
  }
}
