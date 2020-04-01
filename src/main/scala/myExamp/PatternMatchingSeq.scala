package myExamp

object PatternMatchingSeq extends App {
  def f(ints: Seq[Int]): String = ints match {
    case Seq() => "The Seq is empty"
    case Seq(first) => s"The Seq has exactly one elem: $first"
    case Seq(first, second) => s"The Seq has exactly two elem: $first , $second"
    case s@Seq(_, _, _) => s"is a Seq of length three and looks like $s"
    case s: Seq[Int] if s.length == 4 => s"The Seq has four elements and loos like $s "
    case _ => "NO MATCH"
  }

  def f2(ints: Seq[Int]): String = ints match {
    case Seq(first, second, tail@_*) => s"The seq has at least two elements: $first, $second, the rest of Seq is $tail"
    case Seq(first, tail@_*) => s"The seq has at least one element: $first, the rest of Seq is $tail"
    case first +: tail => s"The seq has at least one element: $first, the rest of Seq is $tail ALTERNATE"
    case _ => "NOT MATCH"
  }

  def wrongF[A](ints: Seq[A]) = ints match {
    case Nil => "Empty"
    case head :: Nil => s"One entry $head"
    case _ => " something"
  }

  println(wrongF(List("a")))
  println(wrongF(List("a")))
  println(wrongF(Stream.cons("a", Stream.empty)))
  println(wrongF(LazyList.cons("a", LazyList.empty)))
  //  println(f(Seq(1)))
  //  println(f(Seq(1,2)))
  //  println(f(Seq(1,2,3)))
  //  println(f(Seq(1,2,3,4)))
  //  println(f(Seq(1,2,3,4,5)))

  //println(f2(Seq(1))
}
