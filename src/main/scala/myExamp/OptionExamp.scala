package myExamp

object OptionExamp extends App {

  val op1 = Option(10)
  println(op1.flatMap(f=>Option(f+1)).getOrElse(0))
  println(op1.map(f=>Option(f+1)))
  println(op1.map(f=>f+1))
  println(op1.contains(9))

  val opSeq = Option(Seq(1,2,3,4,5,6,7,7,8,9,21,343,45,2,121,3))
  if (opSeq.contains(Seq(1,2,3,4,5,6,7,7,8,9,21,343,45,2,121,3)))
    println("Yes")
  else
    println("no")

  val a = opSeq.get
    .withFilter(opS => opS % 2 == 0 && opS > 5)
    .map(opS => opS)

  println(a)
  val b = opSeq.map(f=>f.map(i=>i+1)).getOrElse(0)
  println(b)

}
