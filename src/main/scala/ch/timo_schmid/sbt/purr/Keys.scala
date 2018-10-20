package ch.timo_schmid.sbt.purr

import sbt.settingKey

object Keys {

  lazy val catsVersion             = settingKey[String](versionDescription("cats"))
  lazy val catsEffectVersion       = settingKey[String](versionDescription("cats-effect"))
  lazy val circeVersion            = settingKey[String](versionDescription("circe"))
  lazy val fs2Version              = settingKey[String](versionDescription("fs2"))
  lazy val fs2CatsVersion          = settingKey[String](versionDescription("fs2-cats"))
  lazy val http4sVersion           = settingKey[String](versionDescription("http4s"))
  lazy val log4catsVersion         = settingKey[String](versionDescription("log4cats"))
  lazy val logbackVersion          = settingKey[String](versionDescription("logback"))
  lazy val kindProjectorVersion    = settingKey[String](versionDescription("kind-projector"))
  lazy val betterMonadicForVersion = settingKey[String](versionDescription("better-monadic-for"))

  private def versionDescription(lib: String): String = s"The version of $lib to use"

}
