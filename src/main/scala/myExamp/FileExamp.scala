package myExamp

import scala.io.Source
import scala.concurrent._
import ExecutionContext.Implicits.global

object FileExamp extends App{
//  val source = Source.fromFile("D:\\Docs\\Scala\\1.txt")
//val patt = "([а-я]{12,})".r
//  //val str=
//  for(matcStr<- patt.findAllIn(source.getLines().toArray.reverse.mkString)) println(matcStr)
//  //print(str)
//  source.close()
//  //val filewriter = new FileWriter("D:\\Docs\\Scala\\1.txt")
//  //filewriter.write(str)
//  //filewriter.close()

  val sample = 1 to 10
   val isEven: PartialFunction[Int, String] = {
     case x if x % 2 == 0 => x + " is even"
   }

}
