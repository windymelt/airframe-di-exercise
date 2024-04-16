package dev.capslock.exercise.airframedi
package service

import db.Database

class UserManager(db: Database, mailer: mail.Mailer) {
  println("UserManager created")
  
  def addUser(userName: String): Unit = {
    db.add(userName)
    mailer.sendMail(userName)
  }
}
