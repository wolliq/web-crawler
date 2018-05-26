import sbt.Keys._

scalaVersion := "2.11.8"

lazy val commonSettings = Seq(
  name := "web-crawler",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.11.8",
  organization := "org.stef",
  test in assembly := {}
)

libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "1.2.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"
libraryDependencies += "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.5.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.5"

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}