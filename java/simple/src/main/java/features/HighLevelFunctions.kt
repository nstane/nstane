package features

fun main(args: Array<String>) {
    val highLevelFunctions = HighLevelFunctions();
    highLevelFunctions.callFuncWithAction(::println)

    highLevelFunctions.callFuncWithAction() {s -> println(s)}
}


interface Action {
    fun execute();
}

class HighLevelFunctions {

    fun callFuncWithAction(action: (String) -> Unit) {
        action("test");
    }
}