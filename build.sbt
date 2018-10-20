inThisBuild(
  List(
    name := "sbt-purr",
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

sbtPlugin := true
scalacOptions ++= Seq(
  "-feature",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps"
)
