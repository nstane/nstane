package features

fun main(a: Array<String>) {
    //lateinit var narender: features.Person   late initilize

    var narender: Person? = null

    //1. means joye can be null (safe call) check for null first then allow call or access to field
    val joye: Person? = Person(name = "Joye", sex = Sex.MALE)
    joye?.printPerson()

    //2. check if narender not null assign else create new person (elvis operator)
    val john = narender?: Person(sex = Sex.MALE)

    john.printPerson()

    //3. safe cast (as?) Cast to type else return null
    narender = joye as? Person
    narender?.printPerson()

    //4. nut null assersation(!!)  assure that this is not null
    narender = null
    narender!!.printPerson()

    //5. use let library function available in any
    narender = null
    narender?.let { printNonNull(narender) }

}

fun printNonNull(person: Person) {
    println("My name is ${person?.name} and age id ${person?.age}")
}