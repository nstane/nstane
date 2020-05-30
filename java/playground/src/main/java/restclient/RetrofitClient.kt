package restclient

import features.StarWarsService
import retrofit2.Retrofit

class RetrofitClient(val url: String)  {
    inline fun <reified T> create(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)//.addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(T::class.java)
    }
}

fun main() {
    val s = RetrofitClient("https://swapi.dev/api/people/1/").create<StarWarsService>()
    println(s.getHeros());

}