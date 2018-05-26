import sbt.Keys._

lazy val commonSettings = Seq(
  name := "web-crawler",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
  organization := "org.stef",
  test in assembly := {}
)
