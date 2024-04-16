package dev.capslock.exercise.airframedi.mail

object FakeMailer extends Mailer {

  override def sendMail(to: String): Unit =
    println(s"mail not send to $to because it's fake")
}
