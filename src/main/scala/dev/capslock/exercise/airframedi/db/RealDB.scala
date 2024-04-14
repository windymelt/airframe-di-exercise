package dev.capslock.exercise.airframedi.db

case class ConnectionPool()

class RealDB(url: String, connPool: ConnectionPool) extends Database, AutoCloseable {
  println(s"connecting to $url")
  override def add(userName: String): Unit =
    println("add called on RealDB")

  override def close(): Unit = {
      println("closing connection")
  }
}
