package restclient

import retrofit2.Retrofit

class RetrofitClient(val url: String)  {
    inline fun <reified T> create(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .build()
        return retrofit.create(T::class.java)
    }
}