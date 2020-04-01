package myExamp

import scala.collection.{SortedSet, immutable, mutable}
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Collections extends App {
  val ar = new Array[Int](10) // create new Array
  val s = Array("Hello", "World") //new array of strings
  val s0 = s(0)

  val ints = ArrayBuffer[Int]() // create ArrayBuffer variable length Array
  val names = ArrayBuffer[String]()

  ints += 1 //add one elem
  ints += 5 += 6 //multiply elem
  ints ++= List(1, 2, 3) //mult elems from another coll

  ints -= 5 //remove elem if contains
  ints -= (5, 6, 3, 10) //remove mult elem if contains

  ints.insert(0, 123) //insert 0-index, 123-elem
  ints.insertAll(0, List(12, 34, 56)) // for coll
  ints.prepend(3) ////insert 0-index, 123-elem
  ints.clear()

  val a = ArrayBuffer.range('a', 'h')
  a.remove(0)
  a.remove(2, 3)
  a.trimStart(2)
  a.trimEnd(2)

  val seq: Seq[Int] = Seq(1, 2, 3, 4, 4, 1, 2, 3)
  val seq1 = seq
  println(seq1)

  val set = Set(4, 5, 6, 4, 3, 2, 2, 7)
  println(s"Set $set ")
  val set1 = set + 9
  println(s"Set1 $set1")
  val set2 = set1 - 10 //just ignore
  println(s"Set2 $set2 ")

  val sortedSet = set.to(SortedSet)
  println(s"sortedSet $sortedSet")

  val map = Map("hello" -> 1, "world" -> 2)

  println(map("hello"))

  def countWords(text: String) = {
    val counts = mutable.Map.empty[String, Int]
    for (rewWord <- text.split("[ ,!.]+()")) {
      val word = rewWord.toLowerCase
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }

  val source = Source.fromFile("D:/docs/Andersen/CollectionsScala.txt")
  val countMap = countWords(source.mkString)
  source.close()
  println(countMap)

    // Tuples
  def longestWord(words: Array[String])={
    var word=words(0)
    var idx = 0
    for (i<-1 until words.length)
      if(words(i).length>word.length){
        word=words(i)
        idx =i
      }
    (word,idx)
  }

  def  m = 2
  m
  val f  = (x: Int) => x*3
}
