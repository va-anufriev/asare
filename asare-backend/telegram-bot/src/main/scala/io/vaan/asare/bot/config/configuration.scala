package io.vaan.asare.bot.config

import ciris._
import ciris.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.string.Url
import eu.timepit.refined.types.string.NonEmptyString
import eu.timepit.refined.auto._
import cats.implicits._
import cats.effect.Async
import cats.Show
import io.vaan.asare.bot.config.data._

object configuration {
  val config: ConfigValue[Config] =
    (
      // format: off
      (env("TOKEN")       or prop("token")).as[NonEmptyString],
      (env("BACKEND_URL") or prop("backendUrl")).as[String Refined Url].option
      // format: on
    ).parMapN { (token, backendUrl) =>
      Config(
        token = token,
        backendUrl = backendUrl getOrElse "http://0.0.0.0/"
      )
    }
}
