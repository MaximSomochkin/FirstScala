package exampleRodion

object ExampleEmployee extends App {

  //TODO 2
  val man: Employee = Employee(firstName = "Vasily",
    middleName = Some("Victorovich"),
    lastName = "Zverev",
    age = 20,
    salary = 500,
    gender = true)

  println(man)

  val woman: Employee = Employee(firstName = "Vika",
    middleName = Some("Andreevna"),
    lastName = "Petrova",
    age = 40,
    salary = 700,
    gender = false)
  println(woman)

  //TODO 3
  val woman1 = woman.copy(firstName = man.firstName)

  println(woman1)

  //TODO 4
  def encreaseSalaryAge(employee: Employee): Employee = {
    employee.copy(age = employee.age + 1, salary = employee.salary + (employee.salary / 100 * 15))
  }

  println(encreaseSalaryAge(woman1))

  val normMan = Employee(
    firstName = "Petr",
    middleName = Some("Victorovich"),
    lastName = "Zverev",
    age = 25,
    salary = 400,
    gender = true)

  println(normMan)

  val trans = normMan.copy(middleName = None, gender = false)

  println(trans)


}

//TODO 1
case class Employee(
                     firstName: String,
                     middleName: Option[String],
                     lastName: String,
                     age: Int,
                     salary: Int,
                     gender: Boolean
                   ) {
  override def toString: String = {
    " firstName: " + firstName +
      " middleName: " +
      middleName.getOrElse(None) + " " +
      "lastName: " + lastName +
      " age " + age +
      " salary " + salary +
      " gender " + (if (gender) "Man" else "Woman")
  }

}

