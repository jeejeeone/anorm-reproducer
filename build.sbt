ThisBuild / scalaVersion     := "3.3.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "anorm-poc",
    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    libraryDependencies ++= Seq(
      "dev.zio"                 %% "zio"      % "2.0.21",
      "org.playframework.anorm" %% "anorm"    % "2.7.1-f0a340eb-SNAPSHOT",
      "dev.zio"                 %% "zio-test" % "2.0.21" % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
