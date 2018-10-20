import sbt.Keys.scalacOptions

inThisBuild(
  List(
    scalaVersion := "2.12.7",
    organization := "ch.timo-schmid",
    homepage := Some(url("https://github.com/timo-schmid/sbt-purr")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    resolvers += Resolver.sonatypeRepo("releases"),
    developers := List(
      Developer(
        "timo-schmid",
        "Timo Schmid",
        "timo.schmid@gmail.com",
        url("https://github.com/timo-schmid")
      )
    )
  )
)

val `sbt-purr`  = (project in file("plugin")).settings(
  moduleName := "sbt-purr",
  sbtPlugin := true,
  scalacOptions ++= Seq(
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:postfixOps"
  )
)

lazy val `purr` = (project in file(".")).settings(
  skip in publish := true,
).aggregate(`sbt-purr`)
