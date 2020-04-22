package features

import features.dto.People
import retrofit2.http.GET

interface StarWarsService {

    @GET("swapi.co/api/people/1")
    fun getHeros() : People
}