val a = List(1,2,3,4).sum
val b  = Set(-1,-2,1,5)
val c =  8.0
val e = 5

val d = b
//val d = a ++ b
val d = a
def numsFrom(n: BigInt): Stream[BigInt] = n#:: numsFrom(n+1)
val tenOrMore = numsFrom(10)
val tenOrMore = numsFrom(10).take(5)

//-----------------------------------------------------------
//Isertion sort algoritm
def isort (xs: List[Int]) : List[Int]=
  if(xs.isEmpty) Nil
else insert(xs.head, isort(xs.tail))

def insert(x: Int, xs: List[Int]): List[Int] =
  if(xs.isEmpty|| x <= xs.head) x :: xs
else xs.head::insert(x, xs.tail)


//-----------------------------------------------------------