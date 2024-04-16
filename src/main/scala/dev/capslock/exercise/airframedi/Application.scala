package dev.capslock.exercise.airframedi

class Application(userManager: service.UserManager) {
  def run() =
    userManager.addUser("Windymelt")
}
