package exampleRodion

object Hero2 extends App{
  val HP = 100
var  count = 0;
 val hits = Seq(Some(5), None, Some(15), Some(25), None, Some(30), Some(7), Some(40), Some(45))
//  val hits = Seq(Some(5), None, Some(15))
val health = hits.foldLeft(HP){(hp, hits) =>
  count +=1
    val tmp = hp - hits.getOrElse(0)
    if(tmp<0){
      throw new Exception(s"Герой погиб пережив $count ударов")} else tmp
}
  println(count)
}
