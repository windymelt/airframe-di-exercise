package dev.capslock.exercise.airframedi

import wvlet.airframe._

@main def hello(): Unit =
  println("production")
  val prodSession = design.production.newSession
  val prodApp = prodSession.build[Application]
  prodApp.run()
  prodSession.close()
  println("staging")
  design.staging.build[Application] { app =>
    app.run()
  }
  println("local")
  design.local.build[Application] { app =>
    app.run()
  }
  println("test")
  design.test.build[Application] { app =>
    app.run()
  }