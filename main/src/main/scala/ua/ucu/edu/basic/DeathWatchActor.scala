package ua.ucu.edu.basic

import akka.actor.{Props, Actor, Terminated, ActorRef, ActorSystem}

class DeathWatchActor extends Actor {

  override def preStart(): Unit = {
    val actorRef: ActorRef = context.actorOf(Props[VolatileGreetingActor])
    context.watch(actorRef)
    actorRef ! "print this message, please!"
  }

  def receive: Receive = {
    case Terminated(_) => println("looks like an actor has died :(")
  }
}

class VolatileGreetingActor extends Actor {

  def receive: Receive = {
    case s: String => println("stopping"); context.stop(self)
  }
}

object DeathWatchActor extends App {
  val system = ActorSystem("MySystem")
  system.actorOf(Props[DeathWatchActor])
}
