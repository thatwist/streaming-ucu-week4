package ua.ucu.edu

import akka.actor.Actor

object Actors1 {

  // Message Protocol
  case class Greeting(who: String)
  case class Respond(gr: Greeting)

  class GreetingActor extends Actor {
    // Put mutable state in here..

    def receive: Receive = {
      // Define the behavior here..
      case Greeting(who) => println(s"Hello $who")
    }
  }

//  import akka.actor.{ActorSystem, Props}
//
//  val system: ActorSystem = ActorSystem.create("MySystem")
//  val greeter: ActorRef = system.actorOf(Props[Greeting], "greeter")
//
//  val actorRef = ???

}
