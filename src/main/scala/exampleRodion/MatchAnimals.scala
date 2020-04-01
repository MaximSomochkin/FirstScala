package exampleRodion

object MatchAnimals extends App {

  private def swichAnimal(animal: Animal): Unit = {
    animal match {
      case Cat(name, _, _, "RED", _) =>
        //if color.equals("RED") =>
        println(s"$name is RED")
      case Cat(name, Some(v), _, _, _) =>
        //if middleName.nonEmpty =>
        //val midName = middleName.get
        println(s"$name has middleName: $v")
      case Cat(name, _, age, _, tailLength)
        if age >= 5 && tailLength > 15 =>
        println(s"$name is $age years old and has tail legth of $tailLength")
      case Dog(name, _, _, color, _)
        if name.equalsIgnoreCase("Sparky") && color.equalsIgnoreCase("black") =>
        println(s"We found black Sparky")
      case Dog(name, _, _, _, 0) =>
        // if sharpCount == 0 =>
        println(s"The old dog $name has no sharps")
      case Dog(name, _, _, _, _)
        if name.length > 10 =>
        println(s"The dog $name has very long name")
      case c: Cat => println("Other cat")
      case Dog(_, _, _, _, _) => println("Other dog")
      case _ => println("Other animal")
    }
  }

  val catWithMiddle = Cat(name = "Vasya", middleName = Some("Vasilyevich"), age = 3, color = "black", tailLength = 12.3)
  val redCat = catWithMiddle.copy(middleName = None, color = "RED")
  val catAgeTail = redCat.copy(color = "white", age = 5, tailLength = 16)
  val otherCat = redCat.copy(color = "white", age = 5, tailLength = 10)

  val dogBlackSparky = Dog(name = "Sparky", middleName = None, age = 1, color = "black", sharpCount = 32)
  val dogWithoutSarps = dogBlackSparky.copy(name = "oldDog", age = 20, color = "white", sharpCount = 0)
  val longNameDog = dogBlackSparky.copy(name = "loooooooongName")
  val otherDog = dogBlackSparky.copy(name = "someName")

  swichAnimal(catWithMiddle)
  swichAnimal(redCat)
  swichAnimal(catAgeTail)
  swichAnimal(otherCat)

  swichAnimal(dogBlackSparky)
  swichAnimal(dogWithoutSarps)
  swichAnimal(longNameDog)
  swichAnimal(otherDog)


}

abstract class Animal(name: String,
                      middleName: Option[String],
                      age: Int,
                      color: String)

case class Cat(name: String,
               middleName: Option[String],
               age: Int,
               color: String,
               tailLength: Double) extends Animal(name, None, age, color)

case class Dog(name: String,
               middleName: Option[String],
               age: Int,
               color: String,
               sharpCount: Int) extends Animal(name, None, age, color)