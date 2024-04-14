val scala3Version = "3.4.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "airframe-di-exercise",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.wvlet.airframe" %% "airframe" % "24.4.0",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
  )
