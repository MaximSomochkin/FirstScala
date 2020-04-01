package exampleRodion

import scala.concurrent.ExecutionContext
import scala.concurrent._
import scala.concurrent.duration.Duration

object ArgumentInFunc extends App {
  //TODO вызов по имени и выззов по значении, передача функции как аргумента

  implicit val ec = ExecutionContext.global

  def str1: String = {
    println("THere str1")
    "Hello world"
  }

  def str2: String = {
    println("THere str2")
    "Hello world"
  }

  //val res = byName(str1)
  val res = higherOrderFunctions( _ => str1)
  //val res = usual(str1)

  def usual(str: String): Future[String] = {  /// напечатает str 1 рааз
    println("Method start")
    Future(str)
    Future(str)
  }

  def higherOrderFunctions(str: Unit => String): Future[String] = {
    println("Method higherOrderFunctions")
    Future(str(res))
    Future(str(res))
  }

  def byName(str: => String): Future[String] = { // напечатает 2 раза
    println("Method byName")
    Future(str)
    Future(str)
  }

  Await.result(res, Duration.Inf)

//  def callByValue(rnd: Int)= { for(i <- 0 until 3) println(rnd) }
//  def callByName(rnd: => Int): Unit = { for(i <- 0 until 3) println(rnd) }
//
//  callByValue(new scala.util.Random().nextInt())
//  callByName(new scala.util.Random().nextInt())

}
