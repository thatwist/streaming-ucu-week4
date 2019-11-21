import Dependencies._

ThisBuild / version := "0.1"
ThisBuild / organization := "ua.edu.ucu"
ThisBuild / scalaVersion := "2.12.7"
//ThisBuild / scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

lazy val root = (project in file("."))
  .settings(name := "streaming-ucu-week4")
  .aggregate(main, home)

lazy val main = (project in file("main"))
    .settings(
      libraryDependencies ++= Seq(
        akkaStream, akkaHttp, akkaActor, akkaCluster, 
        akkaRemote, akkaPersistence, akkaAgent, // akka
        alpakkaFile, alpakkaCSV, // alpakka
        akkaSlf4j, logback, // logging
        akkaStreamTestKit % Test, akkaHttpTestKit % Test, // akka testkit
        scalaTest % Test, mockitoCore % Test, // testing
        databinder
      ),
      testOptions in Test += Tests.Argument("-oD"),
      fork in run := true,
      connectInput in run := true
    )

lazy val mapred = (project in file("mapred")).settings(
  libraryDependencies ++= Seq(
    "org.apache.hadoop" % "hadoop-core" % "1.2.1"
  ),
  assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
)


lazy val example = (project in file("example")).settings(
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % "test",
    "org.scalacheck" %% "scalacheck" % "1.13.+" % "test",
    "com.storm-enroute" %% "scalameter-core" % "0.10.1"
  )
)

lazy val home = (project in file("home"))
    .settings(
      libraryDependencies ++= Seq(
        akkaActor, akkaRemote, akkaTestKit % Test, scalaTest % Test
      ),
      testOptions in Test += Tests.Argument("-oD")
    )
