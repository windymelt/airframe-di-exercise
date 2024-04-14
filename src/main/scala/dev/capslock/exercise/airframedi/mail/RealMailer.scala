package dev.capslock.exercise.airframedi.mail

class RealMailer extends Mailer {
  override def sendMail(to: String): Unit =
    println(s"sending real mail to $to")
}
