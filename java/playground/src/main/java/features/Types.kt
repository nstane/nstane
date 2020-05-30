package features

/**
 * Benefits of kotlin
 * 1. Type safety
 * 2. null safety {if and when}
 * 3. Loops
 * 4. Default params and name parameter(parama order not matter)
 * 5. extension function //add them to existing class and replace util classses (No more any static util classes)
 *
 * Classes : Normal class, abstract, data, sealed
 *
 */
fun main(args: Array<String>)
{
    // immutable object
    val narender = Person("Narender", 43, Sex.MALE)

    var john: Person? = Person(
        name = "john",
        sex = Sex.MALE
    )

    narender.validatePersonAge();

    narender.printPerson()

    john?.age = 12

    john?.validatePersonAge();

    john?.printPerson()

    john = null

    john?.validatePersonAge();

    john?.printPerson()

    //Inheritance
    Employee("Johny", Sex.MALE, "")

    //Data classes default have toString equals and hashcode implementation and provide clone of object
    val meetingWithNarenderParent =
        Meeting("Student parent meeting", "Discuss student progress in monthly test")

    val meetingWithJohnaParent = Meeting("Student parent meeting", "Discuss student progress in monthly test")
    val areEquals = if(meetingWithNarenderParent == meetingWithJohnaParent) "yes" else "no"
    println("Are both meetings equals? $areEquals")
    println(meetingWithNarenderParent.toString())

    val (subject, agenda) = meetingWithJohnaParent

}

class Employee(
    name: String,
    sex: Sex,
    address: String
): Person(
    name = name,
    sex = sex
) {

}

//By default class is final so use open to override and extend class
open class Person(
    val name: String = "John", // not null
    var age: Int? = 18, // nullable
    val sex: Sex
): A, B
{
    override fun printPerson() {
        if(this?.name != null && this?.age != null)
        println("My name is ${this?.name} and age id ${this?.age}")
    }

    override fun greet() {
        super<A>.greet()
    }

    open fun validatePersonAge()
    {
        var message = this?.age?.let {
            when(it) {   // same can be done with if
                18 -> "I am adult"
                else -> "I am not adult"
            }
        }
        // if message is not null then print else do nothing
        message?.let { println(message) }

    }
}

interface A
{
    fun printPerson()
    fun greet() = println("Hello ")
}

interface B
{
    fun printPerson()
    fun greet() = println("Hello ")
}


enum class Sex
{
    FEMALE,
    MALE
}

sealed class EmployeeEvent  {
    class Fired: EmployeeEvent()
    class Hired: EmployeeEvent()
}


fun handleEmployee(event: EmployeeEvent)
{
    when(event)
    {
        is EmployeeEvent.Fired -> println(" fired")
        is EmployeeEvent.Hired -> println("hired")
    }
}

data class Meeting(var subject:String, var agenda: String) {}
