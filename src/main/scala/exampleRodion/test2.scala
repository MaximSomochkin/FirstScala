package exampleRodion

object test2  extends App {

  val name: Option[String] = None

  name match{
    case Some(value) => print(value)
    case None => print("no name")
  }

  case  class House(roomscount: Int , area: Double, price: Double, poolArea: Option[Int])

  val house1 = House(4, 70.2, 340.5 , None)

  val house2 = house1.copy(price = 700.4, poolArea = Option(25))}

 // val house3 = house1.copy(price = if())
