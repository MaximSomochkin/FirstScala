package exampleRodion

object Address extends App {

  val addr1 = HomeAdress(street = "Svetlaya", street2 = Option(-2), house = 10, apt = 6)

  val one = addr1.street2 match {
    case None => println("no street 2")
    case Some(s) if s >= 0 => println("pos: " + s)
    case Some(s) if s < 0 => println("neg: " + s)

  }

  val addr2 = addr1.copy(apt = 3)

}

case class HomeAdress(
                       street: String,
                       street2: Option[Int],
                       house: Int,
                       apt: Int
                     )
