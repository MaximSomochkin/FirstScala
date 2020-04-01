package exampleRodion

object MainStudent extends App {

  val student = Student(Array(Subject("OOP"), Subject("FP")))
  val student2 = Student(Array(Subject("OOP"), Subject("FP")))
  val student3 = Student(Array(Subject("Usability"), Subject("FP")))

  print(student.array.mkString(" "))

}

case class Student(array: Seq[Subject])
