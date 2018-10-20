# sbt-purr

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/ch.timo-schmid/sbt-purr/badge.svg)](https://search.maven.org/search?q=a:sbt-purr)
[![Build Status](https://api.travis-ci.org/timo-schmid/purr.svg?branch=master)](https://travis-ci.org/timo-schmid/purr)
[![Code Coverage](https://api.codacy.com/project/badge/Grade/dda749696ed34db0a417a4e4567c1522)](https://www.codacy.com/app/timo-schmid/purr?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=timo-schmid/purr&amp;utm_campaign=Badge_Grade)

## Motivation

Purr is an sbt-plugin that helps me add a few libraries to a project I often use, namely:

-   [cats](https://typelevel.org/cats/), [cats-effect](https://typelevel.org/cats-effect/)
-   [fs2](http://fs2.io/)
-   [http4s](https://http4s.org/)
-   [circe](https://circe.github.io/circe/)
-   [logback](https://logback.qos.ch/), [log4cats](https://christopherdavenport.github.io/log4cats/)

By adding this plugin, you automatically pull in those libraries with compatible versions.

## Quickstart

Add the purr plugin to **plugins.sbt**:

```scala
addSbtPlugin("ch.timo-schmid" % "sbt-purr" % "{ latest version }")
```

In your **build.sbt**, enable the purr plugin for your webserver project:

```scala
lazy val server = (project in file("server")).enablePlugins(PurrPlugin)
```

That's it! Purr will automatically add those libraries in recent versions:
```scala
Seq(
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
  "co.fs2"            %% "fs2-cats"             % fs2CatsVersion.value
)
```

Also, purr will add two plugins:
```scala
Seq(
  "org.spire-math" %% "kind-projector"     % kindProjectorVersion.value    asCompilerPlugin,
  "com.olegpy"     %% "better-monadic-for" % betterMonadicForVersion.value asCompilerPlugin
)
```

## Customizing versions

You can customize each of the versions by setting the keys in
[Keys.scala](plugin/src/main/scala/ch/timo_schmid/sbt/purr/Keys.scala).
An example: At the time of writing this, the latest version of http4s used by purr is "0.19.0-M4",
but now lets say "0.19.0" is released, and you want to update. You don't have to wait for it to change -
just set the **http4sVersion** setting to "0.19.0" (or whatever version you want).

```scala
lazy val server = (project in file("server")).settings(
  http4sVersion := "0.19.0"
).enablePlugins(PurrPlugin)
```

Notice there are no compatibility checks in place. If - for example - your version of http4s depends on a
newer version of cats than circe, they might not be binary compatible.
