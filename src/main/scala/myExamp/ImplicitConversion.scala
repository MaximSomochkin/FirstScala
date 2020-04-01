package myExamp

import scala._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

// Не правильное применение. Перегоняем из одного типа в другой. Используй другие методы для конвертации
// Появилось в 2004 году
object ImplicitConversion extends App {

  case class Elephant(size: Int)

  case class Fly(size: Int)

  private def addToPride(elephant: Elephant): Unit = {
    println("Got it")
  }

  implicit def FlyToElephant(fly: Fly) = Elephant(fly.size) //конверсия из мухи в слона

  addToPride(Fly(5))

}

// Правильное применение. Расширяем класс при помощи имплисита. Подмешивает к уже существующему обьекту новое поведение.
// Появилось в 2004 году
object ImplicitConversion2 extends App {

  trait ICanFly {
    def fly: Unit
  }

  case class Elephant(size: Int)

  case class Fly(size: Int) extends ICanFly {
    override def fly: Unit = println("I can fly")
  }

  private def startFly(iCanFly: ICanFly*): Unit = {
    iCanFly.foreach(_.fly)
  }

  implicit def flyForElefant(elephant: Elephant): ICanFly = {
    new Elephant(elephant.size) with ICanFly {
      override def fly: Unit = println("I can fly too")
    }
  }

  startFly(Fly(2), Elephant(5))


}

// Тупо сахар над имплистным методом из ImplicitConversion2. Под капотом будет тоже самое
// Появилось в 2010 году
object ImplicitClasses extends App {

  trait ICanFly {
    def fly: Unit
  }

  case class Elephant(size: Int)

  case class Fly(size: Int) extends ICanFly {
    override def fly: Unit = println("I can fly")
  }

  private def startToFly(iCanFly: ICanFly*): Unit = {
    iCanFly.foreach(_.fly)
  }

  implicit class FlyElephant(elephant: Elephant) extends ICanFly {
    override def fly: Unit = println("I can fly too")
  }

  startToFly(Fly(5), Elephant(10))
}

//Типизированный метод ожидает получение неявного тайп класса. В данном случае, мы ожидаем у класса типа Т наличие штуки помогающей летать
// Появилось в 2006 году
object ImplicitParams extends App {

  case class Plain(model: String)

  case class FlyingPastaMonster(name: String)

  trait FlyHelper[T] {
    def support(t: T): String
  }

  implicit val plainFlyHelp = new FlyHelper[Plain] {
    override def support(plain: Plain): String = s"some science for plain: ${plain.model}"
  }

  implicit val flyingPastaMonsterFlyHelp = new FlyHelper[FlyingPastaMonster] {
    override def support(monster: FlyingPastaMonster): String = s"some magic for FlyingPastaMonster: ${monster.name}"
  }

  def startFly[T](whoIsThis: T)(implicit flyHelper: FlyHelper[T]) = {
    println(flyHelper.support(whoIsThis))
  }

  startFly(Plain("Мрія"))
  startFly(FlyingPastaMonster("John"))
}
