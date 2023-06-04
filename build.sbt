ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "zio"
  )

libraryDependencies += "dev.zio" %% "zio" % "2.0.9"
libraryDependencies += "dev.zio" %% "zio-streams" % "2.0.9"
