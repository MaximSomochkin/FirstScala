package myExamp

object Function extends App {
  def addOne1(i: Int): Int = {
    println(i + 1)
    i + 1
  }

  def addOne(i: Int) = i + 1 //Simple function (method) or
  val sF = addOne(5)

  def withoutArgs = 2 + 3 //without arguments
  val f = (i: Int) => i + 1 //simple function
  val resF = f(2)


  def adder(a: Int, b: Int) = a + b

  val add = adder(5, _) //Partial function
  println(add)
  val add2 = add(3)
  println(add2)

  def multNum(a: Int)(b: Int) = a * b

  val mul1 = multNum(3) _ //Curried function
  println(mul1)
  val mul2 = mul1(5)
  println(mul2)

  def varFunc(s: String*) = {
    args.map(s => s.capitalize).mkString(" ")
  }

  val v = varFunc("Vasya")
  println(v)

  val j = if (2 == 5) 2 else 3

  val r = j match {
    case 2 => 3 * 3
    case _ => 0
  }

  println(r)
}
