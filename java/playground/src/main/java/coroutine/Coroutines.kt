package coroutine

import kotlinx.coroutines.*


fun main(){
    launchDemo()
}


fun launchDemo() {
    println("Start")
    GlobalScope.launch {
        //delay(1000)
        println("from GlobalScope.launch")
        //apiCall()
    }

    runBlocking {
        delay(500)
        println("from runBlocking")
        apiCall()
    }

    GlobalScope.async {

    }

    println("end")
}

suspend fun apiCall() {
    println("api call function")
}
