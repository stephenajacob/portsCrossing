name := """PortsCrossing3"""


version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"
crossScalaVersions := Seq("2.11.6", "2.11.7")

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.7.play24",
  "org.specs2" %% "specs2-core" % "3.6.5" % "test",
  "org.specs2" %% "specs2-junit" % "3.6.5" % "test",
  "org.specs2" %% "specs2-mock" % "3.6.5" % "test",
  "org.reflections" % "reflections" % "0.9.8" notTransitive (),
  "org.webjars" % "swagger-ui" % "2.1.8-M1",
  "io.swagger" %% "swagger-play2" % "1.5.1",
  ws
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node


fork in run := true