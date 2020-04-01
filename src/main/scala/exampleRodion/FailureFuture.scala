package exampleRodion

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

object FailureFuture extends App {
  val results: Seq[Future[String]] = Seq(
    Future.successful("Успех1"),
    Future.successful("Успех2"),
    Future.failed(new Exception("Ошибка1")),
    Future.failed(new Exception("Ошибка2")),
    Future.successful("Успех3"),
    Future.failed(new Exception("Ошибка3")),
  )
  val successRes = results.map(f => f.transform {
    case Success(value) => Success(value)
    case Failure(exception) => Success(exception.getMessage)
  })
  println(successRes)

  val fs: Future[Seq[String]] = successRes.foldLeft(Future.successful[Seq[String]](Seq.empty)) {
    (futureAcc, currentFuture) =>
      for {
        ac <- futureAcc
        cf <- currentFuture
      } yield ac :+ cf

  }
  val f = Await.result(fs, Duration.Inf)
  println(f)


  val fs1: Future[Seq[String]] = successRes.foldLeft(Future.successful[Seq[String]](Seq.empty)) {
    (futureAcc, currentFuture) => futureAcc flatMap (x => currentFuture.map { y => x :+ y })
  }
 // val fs2= successRes.flatMap(f=>f.)
  val f2 = Await.result(fs1, Duration.Inf)
  println(f2)


  def method2: Future[String] = Future.failed(new Exception("No result2"))

  val m2 = method2.transformWith {
    case Success(value) => Future(value)
    case Failure(exception) => Future(exception.getMessage)
  }
  Await.result(m2, Duration.Inf)
  println(m2)


  def method1: Future[String] = throw new Exception("No result1")

  val m1: Future[String] = Try(method1).transform(
    s => Success(Future(s.value.get.get)),
    f => Success(Future(f.getMessage))).get

  Await.result(m1,Duration.Inf)
  println(m1)


}
