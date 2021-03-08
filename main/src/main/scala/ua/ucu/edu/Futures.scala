package ua.ucu.edu

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

object Futures extends App {

  trait Egg
  trait Tea
  trait Cracked extends Egg

  def chickenMagic(): Egg = new Egg {}
  def crack(e: Egg): Cracked = new Cracked {}
  def brew(): Tea = new Tea {}

  import scala.concurrent.ExecutionContext.Implicits.global

  // ExecutionContext decides how to schedule and on what thread
//  implicit val executionContext: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
//  implicit val executionContext1: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global

  def eggF: Future[Egg] =
    Future {
      println("magic..")
      chickenMagic()
    }

  val crackedEggF: Future[Cracked] = eggF.map(crack)

  val teaF: Future[Tea] = Future {
    println("brewing")
    brew()
  }

  crackedEggF.onComplete{
    case Success(crackedEgg) =>
    case Failure(exception)  =>
  }

  val breakfast: Future[(Cracked, Tea)] = crackedEggF.zip(teaF)

  println("main flow")

  Thread.sleep(5000)



  trait Comparator[T] {
    def compare(a: T, b: T): Boolean
  }

  def sort[T: Ordering](seq: Seq[T]) = {
    // bubble sort
      //..
    val a: T = ???
    val b: T = ???

    implicitly[Ordering[T]].compare(a, b)
  }

  import Ordering.String

  List("").sortBy()




}
