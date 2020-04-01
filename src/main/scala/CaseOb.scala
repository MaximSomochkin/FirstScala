 object CaseOb extends App{

   abstract class MobDevice()

   case class CellPhone(name: String, camera: Boolean, color: Option[String]) extends MobDevice
   case class SimplePhone (buttons: Boolean, color: String)

   val simplePhone = SimplePhone(buttons = true,color = "white")
   def casePhone(device: MobDevice): String = device match {
     case CellPhone(name,_,_) =>s"This is mobile phone $name"
     case _=>"other device"
   }
   println(simplePhone)
 }
