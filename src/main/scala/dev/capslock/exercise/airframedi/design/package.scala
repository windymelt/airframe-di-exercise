package dev.capslock.exercise.airframedi

import wvlet.airframe.*

package object design {
  val production = newDesign
    .bind[db.ConnectionPool].toInstance(db.ConnectionPool())
    .bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
      db.RealDB("mysql://foo:bar@db.example.com:3306/foodb", pool),
    )
    .bind[mail.Mailer].toInstance(
      mail.RealMailer(),
    )

  val staging = newDesign
    .bind[db.ConnectionPool].toInstance(db.ConnectionPool())
    .bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
      db.RealDB("mysql://foo:bar@db.staging.example.com:3306/foodb", pool),
    )
    .bind[mail.Mailer].toInstance(
      mail.FakeMailer(),
    )

  val local = newDesign
    .bind[db.ConnectionPool].toInstance(db.ConnectionPool())
    .bind[db.Database].toProvider( (pool: db.ConnectionPool) =>
      db.RealDB("mysql://foo:bar@localhost:3306/foodb", pool)
    )
    .bind[mail.Mailer].toInstance(
      mail.FakeMailer()
    )

  val test = newDesign
    .bind[db.Database].toInstance(
      db.FakeDB()
    )
    .bind[mail.Mailer].toInstance(
      mail.FakeMailer()
    )
}
