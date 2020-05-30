package features

class CompainTypes {
    //Creating static method in companion types class //Objects are by default singleton
    companion object {
        fun catchMe() {
            println("you will be get caught static")
        }
    }
}

//singlton
object Program {
    fun run(){
        println("features.Program ${this} starting")
    }

    fun kill(){
        println("features.Program ${this} killed")
    }
}
fun main(args: Array<String>) {
    CompainTypes.catchMe();
    Program.run()
    Program.kill()
}