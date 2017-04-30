name := """data-collections-service"""

version := "1.0-SNAPSHOT"

enablePlugins(PlayJava)

scalaVersion := "2.11.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  javaJpa,
  "org.mockito" % "mockito-core" % "2.1.0",
  javaWs % "test",
  "org.hibernate" % "hibernate-core" % "5.2.5.Final",
  jdbc,
  "org.postgresql" % "postgresql" % "9.4-1200-jdbc41",
  "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3",
  "be.objectify" %% "deadbolt-java" % "2.5.4"
)