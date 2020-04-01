package myExamp

import scala.collection.mutable
import scala.io.Source

object MapEx extends App {
//val source = Source.fromFile("D:\\Docs\\Scala\\1.txt")
val source = Source.fromURL("https://abakbot.ru/online-5/301-rus-eng-alphabet")
  //val alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
  val freq = mutable.SortedMap[Char, Int]()
for (ch<-source.toArray.filter((ch1) => (ch1 <= 'Я' && ch1 >= 'А')).mkString) freq(ch) = freq.getOrElse(ch, 0) +1

  for((k,v)<-freq) println(s"$k->$v")

}
