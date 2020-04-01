package myExamp

import scala.Option
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration


object ForComprehension extends App {
  val listInt: Seq[Int] = List(1, 2, 3)
  val listString: Seq[String] = List("one", "two", "three")

  val res = for {
    lI <- listInt
    lS <- listString
    if (lI < 3)

  } yield (lI, lS)

  val res2 = listInt.filter(x => x < 3).flatMap(x => listString map (y => (x, y)))
  println(res2)
  //-----------------------------------------------------------------------------

  val optonInt: Option[Int] = Some(5)
  val futureInt: Future[Int] = Future(5)

//    val res2 = for {
//      oInt <- optonInt
//      futInt <- futureInt
//    } yield (oInt, futInt)

  val res3: Option[Future[Int]] = optonInt.map(o => futureInt.map(f => o + f))
  val res4: Future[Option[Int]] = futureInt.map(f => optonInt.map(o => f + o))
  Await.result(futureInt, Duration.Inf)
  println(res3)
  println(res4)
}