package dev.capslock.exercise.airframedi
import dev.capslock.exercise.airframedi.db.Database
import dev.capslock.exercise.airframedi.mail.Mailer
import wvlet.airframe.*

class Application(database: Database, mailer: Mailer) {
  def run() =
    database.add("Windymelt")
    mailer.sendMail("windymelt@example.com")
}
