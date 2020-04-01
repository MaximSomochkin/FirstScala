package exampleRodion

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Hero1 extends App {


  //val hits = Seq(5, 15, 25, 30, 7, 40, 45)

  val HP = 100
  val damages = Seq(5, 15, 25, 30, 7, 40, 45)
  //val damages = Seq(5, 15)

  val newHP = damages.foldLeft(HP){ (hp, damage) =>
    val tempHP = hp - damage
    if (tempHP >0) throw new Exception("Герой погиб") else tempHP
  }
  println(newHP)

}
