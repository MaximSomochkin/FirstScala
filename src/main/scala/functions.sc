////1
//def sign(x: Int) =
//  if (x==0) x
//else if (x<0) -1
//else 1
//
//print(sign(23))
//print(sign(0))
//print(sign(-34))
//
////2
//print({}.isInstanceOf[Unit])

//3
//var x: Unit = 1
//var y = 2
//x=y=1

//3
//for (i <- 10 to 0 by -1) println((i)+" ")

//4
//def countDown(n: Int): Unit = {
//  for(i<- n to 0 by -1)
//    print(i + " ")
//}
//countDown(10)

////5
//var m: Long = 1
//for (i <- "Hello")
//  m *= i.toLong
//print(m+"L")

////6
print("Hello".foldLeft(1L)(_ * _.toInt))

//7
//def productS(s:String): Unit ={
//  print(s.foldLeft(1L)(_ * _.toInt))
//}

//8
def productS(s:String): Long={
  var x = 1L
  if(s.isEmpty) 0L

  else {

    x *= s.charAt(0)
    productS(s.substring(1))
  }
 // print(x)
  x
}

productS("h")

val sample = 1 to 10
val isEven: PartialFunction[Int, String] = {
  case x if x % 2 == 0 => x + " is even"
}