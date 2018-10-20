package ch.timo_schmid.sbt.purr

import sbt._
import sbt.Keys.libraryDependencies
import Syntax._
import ch.timo_schmid.sbt.purr.Keys._

object PurrPlugin extends AutoPlugin {

  val autoImport: Keys.type = Keys

  override def projectSettings: Seq[Def.Setting[_]] = {
    Seq(
      catsVersion             := Defaults.Versions.cats,
      catsEffectVersion       := Defaults.Versions.catsEffect,
      circeVersion            := Defaults.Versions.circe,
      fs2Version              := Defaults.Versions.fs2,
      fs2CatsVersion          := Defaults.Versions.fs2Cats,
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
