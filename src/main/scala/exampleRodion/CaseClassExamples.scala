package exampleRodion

// ctrl+alt+l - формат кода
object CaseClassExamples extends App {

  case class User(id: Long, name: String, age: Int = 33) {
    def this(id: Long) = this(id, "max")
    def this(name: String, age: Int) = this(id=1,name)


  }

  val userMax: User = User(1, "Max", 33)
  val userMax2: User = User(id = 2, name = "Max", age = 35)
  val userMax3: User = User(name = "max", id = 3, age = 33)
  val userMax4: User = User(name = "max", id = 4)
  val userMax5: User = new User(id = 5)

  val testEntity: TestEntity = new TestEntity(field1 = "one",field2 = "two",field3 = "three",field4 = "four",field5 = "five")
  {
    field1 = "sdas"
//    super.field2 = "sddasd"

  }
val t = testEntity.field2


//  val testEntity1: TestEntity = new TestEntity(field1 = "one",field2 = "two",field3 = "three",field4 = "four",field5 = "five")
//  {
//    val one: String = this.field1
//    val two: String = this.field2
//  }


}
                                            //внутри         экземпляр
class TestEntity(var field1: String,       // r/w, видим      // r/w, видим
                 val field2: String,        // r, видим       // r, видим
                 private var field3: String, // r/w видим
                 private val field4: String, // r, видим
                 field5: String){             // r, видим




}
//class TestEntity2 extends TestEntity("childfiled1",
//  field2 = "childfiled2",
//  field3 = "childfiled3",
//  field4 = "childfiled1",
//  field5 = "childfiled1"){


//}

//object test extends App{
//
//  val testEntity: TestEntity= new TestEntity(field1 = "fgh", field2 = "hg", field3 = "gf", field4 = "jhh", field5 = "gg")
//
//  var f : String =testEntity.field1
//  var f1 : String =testEntity.field2
//}
