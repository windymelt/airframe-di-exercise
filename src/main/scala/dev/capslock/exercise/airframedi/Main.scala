package dev.capslock.exercise.airframedi

import wvlet.airframe.*

@main def hello(): Unit =
  println("production")
  design.production.withSession { sess =>
    design.production.build[Application] { app =>
      app.run()
      // switch to power user
      println("entering power user mode")
      sess.withChildSession(design.productionWithPowerAccess) { powerSession =>
        val powerApp = powerSession.build[Application]
        powerApp.run()
      }
      println("eject power user mode")
    }
  }
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
