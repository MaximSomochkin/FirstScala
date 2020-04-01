import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

val ar = new Array[Int](10) // create new Array
val s = Array("Hello","World") //new array of strings
val s0 = s(0)

val ints = ArrayBuffer[Int]() // create ArrayBuffer variable length Array
val names= ArrayBuffer[String]()

ints +=1//add one elem
ints += 5 +=6//multiply elem
ints ++=List(1,2,3) //mult elems from another coll

ints -= 5//remove elem if contains
ints -= (5,6,3,10)//remove mult elem if contains

ints.insert(0,123) //insert 0-index, 123-elem
ints.insertAll(0,List(12,34,56)) // for coll
ints.prepend(3)////insert 0-index, 123-elem
ints.clear()

val a = ArrayBuffer.range('a','h')
a.remove(0)
a.remove(2,3)
a.trimStart(2)
a.trimEnd(2)