package dev.capslock.exercise.airframedi.db

class FakeDB extends Database {
  override def add(userName: String): Unit =
    println("add called on FakeDB")
}
