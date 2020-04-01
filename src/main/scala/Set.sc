import scala.collection.mutable

val set  = mutable.Set[Int]()
set +=1 +=2 +=1
set ++= Vector(1,2,3,4,5,6,1,2,3)
set remove(8)
set.contains(7)

val symSet1 = Set("one","two")
val symSet2 = Set("three","four", "one")

symSet1 intersect(symSet2)
symSet1 &~ symSet2
