import java.util.Objects
import java.util.concurrent.Callable

class Reactive<T> {

   // val onSuccess = TODO();
    lateinit var onErrorReturn:String
    fun execute():Reactive<T> {
        return this
    }

    fun doOnError(consumer: Function<T>): Reactive<T> {
        //onError = consumer
        consumer.apply { print("error") }
        return this
    }

    //fun onError(value:String):Unit = onErrorReturn = value
}


fun main() {
    val str: String? = null
    Objects.isNull(null)
    //validate(str)

    val runnable = Runnable { println("hello") }

    Thread(runnable)
}

fun validate(obj: String?) {
    Objects.nonNull(obj)
    Objects.requireNonNull(obj,"This field is required")
}
