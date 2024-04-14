package dev.capslock.exercise.airframedi.mail

class FakeMailer extends Mailer {

  override def sendMail(to: String): Unit =
    println(s"mail not send to $to because it's fake")
}
