package services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<ResponseBody>
}