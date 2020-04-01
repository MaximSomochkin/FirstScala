class Person{
  var name: Option[String] = None
  var age: Option[Int] = None

  override def toString: String = s"$name,$age"
}


object Person{
  def apply(name:Option[String]): Person = {
    var p=new Person()
    p.name=name
    p
  }

  def apply(name:Option[String], age:Option[Int]): Person = {
    var p=new Person()
    p.name=name
    p.age=age
    p
  }
 val p1 = Person(Some("hdjf"))
  print(p1)
}