package dev.capslock.exercise.airframedi.mail

trait Mailer {
  def sendMail(to: String): Unit
}
