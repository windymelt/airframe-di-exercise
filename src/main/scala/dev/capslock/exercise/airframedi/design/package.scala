package dev.capslock.exercise.airframedi

import wvlet.airframe.*

package object design {
  val production = newDesign
    .bind[db.ConnectionPool].toInstance(db.ConnectionPool())
    .bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
      db.RealDB("mysql://foo:bar@db.example.com:3306/foodb", pool),
    ).onInit(_ => println("db connection started"))
    .bind[mail.Mailer].toInstance(mail.RealMailer())
    .withProductionMode
    // 自明な依存性は省略できる
    // .bind[UserManager].toSingleton

  val productionWithPowerAccess = production.bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
    db.RealDB("mysql://root:root@db.example.com:3306/foodb", pool)
  )

  val staging = newDesign
    .bind[db.ConnectionPool].toInstance(db.ConnectionPool())
    .bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
      db.RealDB("mysql://foo:bar@db.staging.example.com:3306/foodb", pool),
    )
    .bind[mail.Mailer].toInstance(mail.FakeMailer)
    //.bind[UserManager].toSingleton

  val local = newDesign
    .bind[db.ConnectionPool].toInstance(db.ConnectionPool())
    .bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
      db.RealDB("mysql://foo:bar@localhost:3306/foodb", pool)
    )
    .bind[mail.Mailer].toInstance(mail.FakeMailer)
    //.bind[UserManager].toSingleton

  val test = newDesign
    .bind[db.Database].toInstance(db.FakeDB())
    .bind[mail.Mailer].toInstance(mail.FakeMailer)
    //.bind[UserManager].toSingleton
}
