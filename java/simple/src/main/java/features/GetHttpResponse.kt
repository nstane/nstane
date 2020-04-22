package features

import okhttp3.ResponseBody
import restclient.RetrofitClient
import services.GitService

fun main(){

    val gitService : GitService = RetrofitClient("https://api.github.com/").create()

    val response: ResponseBody? = gitService.getRepos("nstane").execute().body()
    print(response?.bytes()?.let { String(bytes = it) })
}