ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "graphql-restassured-scala-sbt"
  )

libraryDependencies += "io.rest-assured" % "scala-support" % "5.2.0"
libraryDependencies += "junit" % "junit" % "4.13.2"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.5"
