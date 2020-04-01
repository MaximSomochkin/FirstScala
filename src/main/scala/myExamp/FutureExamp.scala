package myExamp

import myExamp.FutureExamp.isSuccess

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}
import scala.language.postfixOps

object FutureExamp extends App {
  //  @volatile var totalA = 0
  //  val text = Future{
  //    "na" * 16 + "BATMAN!!!!"
  //  }
  //
  //  text foreach{txt =>
  //    totalA += txt.count(_ == 'a')
  //  }
  //
  //  text foreach{txt => totalA += txt.count(_=='A')}

  //  val source = Source.fromFile("D:\\Docs\\Scala\\1.txt")
  //  val f = Future{source.getLines()}
  //  val f1 = Future {
  //    2 +2
  //  }
  //
  //println(Await.result(Future{2+2},Duration.Inf))
  //
  //  val sum = Future {
  //    (1L to 30L).filter(l => l % 2 == 0 ).map(l=>l+3).mkString(" ")
  //Thread.sleep(100)
  //  }
  //  //Thread.sleep(1000)
  //  //println(Await.result(sum, Duration.Inf))
  //  Thread.sleep(1000)
  //  println(Await.result(sum, Duration.Inf))

  def donutStock(donut: String): Future[Int] = Future {
    println("Checking donut stock")
    10
    // throw new OutOfMemoryError()
  }

  // blocking result
  val vanillaDonutStock = Await.result(donutStock("vanilla donut"), 1 seconds)

  //noneBlocking
  donutStock("nonBlocking Vanilla donut").onComplete {
    case Success(stock) => println(s"Stock for vanilla donut = $stock")
    case Failure(e) => (s"Failed to find $e")
  }
  //Thread sleep(3000)

  //flatMap example

  //def method which return Future[boolean]
  println("Chaining Futures using flatMap")

  def buyDonuts(quantity: Int): Future[Boolean] = Future {
    println(s"buying $quantity donuts ")
    true
  }

  //using flatMap
  val buyingDonuts: Future[Boolean] = donutStock("plain donut").flatMap(qty => buyDonuts(qty))
  val isSuccess = Await.result(buyingDonuts, 5 seconds)
  println(s"Buying success = $isSuccess")

  //using for comprehension
  for {
    stock <- donutStock("vanilla donut")
    isSuccess <- buyDonuts(stock)
  } yield println(s"Buying success = $isSuccess")

  donutStock("dfd").flatMap(stock => buyDonuts(stock).map(isSuccess => println(s"Buying success = $isSuccess")))

  //Future[Option[Int]]
  def donutOptStock(donut: String): Future[Option[Int]] = Future {
    println(s"checking Stock")
    if (donut == "vanilla donut") Some(10) else None
  }

  //Access
  println("Access Option value returned by future using map() method")
  donutOptStock("vanila donut")
    .map(someQty => println(s"Buying ${someQty.getOrElse(0)} vanilla donuts"))

  //calling map() from multiple futures
  println(s" Calling map() method over multiple futures")
  val resultFromMap: Future[Future[Boolean]] = donutOptStock("vanilla donut")
    .map(someQty => buyDonuts(someQty.getOrElse(0)))

  ////calling flatMap() from multiple futures

  val resultFromFlatMap: Future[Boolean] = donutOptStock("vanilla donut")
    .flatMap(someQty => buyDonuts(someQty.getOrElse(0)))


  //Future traverse
  println(" Define a method which returns a Future Option")

  def donutStockTrav(donut: String): Future[Option[Int]] = Future {
    println(s"checking Stock")
    if (donut == "vanilla donut") Some(10) else None
  }

  println(s"\n Create a List of future operations")
  val futureOperations: Seq[Future[Option[Int]]] = Seq(
    donutOptStock("vanilla donut"),
    donutOptStock("plain donut"),
    donutOptStock("chocolate donut"))


  println(s"\n Call Future.traverse to convert all Option of Int into Int")
  val futureTraverseResult = Future.traverse(futureOperations) { futureSomeQty =>
    futureSomeQty
      .map(someQty => someQty.getOrElse(0))
  }


  futureTraverseResult.onComplete {
    case Success(result) => println(s"Result: $result")
    case Failure(exception) => (println(exception))
  }

  //foldLeft
  println(s" \nCall Future.foldLeft to fold over futures results from left to right")
  val futureFoldLeft = Future.foldLeft(futureOperations)(0) {
    case (acc, someQty) => acc + someQty.getOrElse(0)
  }
  futureFoldLeft.onComplete {
    case Success(value) => println(s"ResultFold: $value")
    case Failure(exception) => println(exception)
  }


  //Future andThen
  println(s"\n Call Future.andThen with a PartialFunction")
  val donutStockOperation = donutStock("vanilla donut")
  donutStockOperation andThen {
    case stockQty => println(s"donutstock: $stockQty")
  }

  Future(1).map(_ + 1).map(_ + 1).recoverWith {
    case exception: Exception => Future(0)
  }
.map(_+1)

  //Future recover
  println("\n Define a method which returns a Future")

  def donutStockRecover(donut: String): Future[Int] = Future {
    if (donut == "vanilla donut") 10
    else throw new IllegalStateException("Out of stock")
  }

  println(" Execute donutStockRecover() future operation")
  donutStockRecover("unknown donut").recover {
    case e: IllegalStateException if e.getMessage == "Out of stock" => 0
  }
    .onComplete {
      case Success(donut) => println(s"Results $donut")
      case Failure(exception) => println(exception)
    }

  //recowerWith
  donutStockRecover("unknown donut").recoverWith {
    case e: IllegalStateException if e.getMessage == "Out of stock" => Future.successful(0)
  }
    .onComplete {
      case Success(donut) => println(s"Results $donut")
      case Failure(exception) => println(exception)
    }

  //fallBack
  donutStockRecover("unknown donut")
    .fallbackTo(donutStock("vanilla donut"))
    .onComplete {
      case Success(donut) => println(s"Results $donut")
      case Failure(exception) => println(exception)
    }

  //transform transformWith
  //
  println(s"\n Create a List of future operations")
  val futureOperations2: Seq[Future[Option[Int]]] = Seq(
    donutOptStock("vanilla donut"),
    donutOptStock("plain donut"),
    donutOptStock("chocolate donut"),
    donutOptStock("milkChoc donut"))

//  val seqF = futureOperations.foldLeft(Future.successful[Seq[String]](Seq.empty)) {
//    (futAcc, curFut)=> for {
//      acc <- futAcc
//      cur<-curFut
//    } yield (acc :+ cur)
//  }

//  val seqFl = futureOperations.foldLeft(Future.successful[Seq[String]](Seq.empty)){(futAcc, curFut)=> futAcc.flatMap(a=> curFut.map(c=>a:+c))
//
//  }
  val c = Future(futureFoldLeft)
val a = c.map(f=>f+"1")
val b = c.flatMap(f=>f.map(e=>e+e))
println(a)
  println(b)

  val d= c.recover{
    case exception: Exception => println(exception)
  }

  val e = a fallbackTo(b)

  val f = a.recoverWith{
    case exception: Exception => Future(d)
  }

  def createFuture(in: Int) = Future {
    println(in)
    in
  }

  //это  последовательно
  val fn: Future[Int] = for {
    a <- createFuture(1)
    b <- createFuture(2)
    c <- createFuture(3)
  } yield (a + b + c)

  Await.result(fn, Duration.Inf)

  //createFuture(1)
  // .flatMap(a => createFuture(2)
  // .flatMap(b => createFuture(3)
  // .map(c => a + b + c)))

  val f1 = createFuture(4)
  Thread.sleep(1)
  val f2 = createFuture(5)
  val f3 = createFuture(6)

  //это  асинсхронно
  val f4: Future[Int] = for {
    a <- f1
    b <- f2
    c <- f3
  } yield (a + b + c)

  Await.result(f4, Duration.Inf)

}





