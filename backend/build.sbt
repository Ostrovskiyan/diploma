name := """diploma"""

version := "1.0-SNAPSHOT"

enablePlugins(PlayJava)

scalaVersion := "2.11.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  filters,
  javaJpa,
  "org.mockito" % "mockito-core" % "2.1.0",
  javaWs % "test"
)