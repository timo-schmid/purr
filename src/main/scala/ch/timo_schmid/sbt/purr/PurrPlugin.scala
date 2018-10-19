package ch.timo_schmid.sbt.purr

import sbt._
import sbt.Keys.libraryDependencies

import Syntax._

object PurrPlugin extends AutoPlugin {

  object autoImport {
    
    def versionDescription(lib: String): String = s"The version of $lib to use"

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

  }

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = {
    Seq(
      catsVersion             := Defaults.Versions.cats,
      catsEffectVersion       := Defaults.Versions.catsEffect,
      circeVersion            := Defaults.Versions.circe,
      fs2Version              := Defaults.Versions.fs2,
      fs2CatsVersion          := Defaults.Versions.fs2,
      http4sVersion           := Defaults.Versions.http4s,
      log4catsVersion         := Defaults.Versions.log4cats,
      logbackVersion          := Defaults.Versions.logback,
      kindProjectorVersion    := Defaults.PluginVersions.kindProjector,
      betterMonadicForVersion := Defaults.PluginVersions.betterMonadicFor,
      libraryDependencies := Seq(
        "org.typelevel"     %% "cats-core"            % catsVersion.value,
        "org.typelevel"     %% "cats-effect"          % catsEffectVersion.value,
        "org.http4s"        %% "http4s-blaze-server"  % http4sVersion.value,
        "org.http4s"        %% "http4s-blaze-client"  % http4sVersion.value,
        "org.http4s"        %% "http4s-circe"         % http4sVersion.value,
        "org.http4s"        %% "http4s-dsl"           % http4sVersion.value,
        "io.circe"          %% "circe-core"           % circeVersion.value,
        "io.circe"          %% "circe-parser"         % circeVersion.value,
        "io.circe"          %% "circe-generic"        % circeVersion.value,
        "ch.qos.logback"    %  "logback-classic"      % logbackVersion.value,
        "io.chrisdavenport" %% "log4cats-core"        % log4catsVersion.value,
        "io.chrisdavenport" %% "log4cats-log4s"       % log4catsVersion.value,
        "co.fs2"            %% "fs2-core"             % fs2Version.value,
        "co.fs2"            %% "fs2-cats"             % fs2CatsVersion.value,
        "org.spire-math"    %% "kind-projector"       % kindProjectorVersion.value    asCompilerPlugin,
        "com.olegpy"        %% "better-monadic-for"   % betterMonadicForVersion.value asCompilerPlugin
      )
    )
  }

}
