package myExamp

object ByName extends App{
  def m1(i: Int): String = i.toString

  //println(s"m1 ${m1(5)}")

  val m2: (Int) => String = i => i.toString
  val res: String =m2(5)
  println(s"m2 res")

  val m3: Int => String = _.toString

  val m4 = m2(1)


  def byValue(i: Int): String = i.toString

  def byName(i: => Int): String = i.toString

  def byHOF(i: Int => String): String = i(1)

  val m5 = new Function[Int,String] {
    override def apply(v1: Int): String = v1.toString
  }

}
