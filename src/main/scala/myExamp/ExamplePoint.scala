package myExamp

object ExamplePoint extends App {

  //val point = new Point
  // tuples
  //  val planets =
  //    List(("Mercury", 57.9),("Venus", 34.5),("Earth", 35.5), ("Mars", 23.2))
  //
  //  planets.foreach{
  //    case ("Mars", distance)=>
  //      println(s"Mars is a $distance million kilometers from Sun")
  //    case _ => println("none")
  //
  //  }

  // Mixin 1
  //  val d = new D
  //  println(d.message)
  //  println(d.loudMessage)

  val richStringIter = new RichStringIter
  richStringIter.foreach(println)

}

abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next(): T
}

class StringIterator(s: String) extends AbsIterator {
  override type T = Char
  private var i = 0;

  override def hasNext: Boolean = i < s.length

  override def next() = {
    val ch = s.charAt(i)
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T=> Unit): Unit = while (hasNext) f(next())
}

class RichStringIter extends StringIterator("Scala") with RichIterator



//mixin 1
//abstract class A{
//  val message: String
//}
//class B extends A{
//  override val message: String = "I'm instance of class B"
//}
//trait C extends A{
//  def loudMessage=message.toUpperCase
//}
//class D extends B with C


class Point {
  private var _x = 0
  private var _y = 0
  val bound = 100

  def x = _x

  def x_=(newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y

  def y_=(newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("Warning")
}