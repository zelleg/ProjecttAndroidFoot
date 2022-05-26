package com.example.myapplication.model.data

import com.example.myapplication.model.response.TeamResponse
import com.example.myapplication.model.response.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import javax.inject.Inject

class SoccerApi @Inject constructor(private val service: Service){
    suspend fun getTeams(): TeamsResponse = service.getTeams()
    suspend fun getTeam(teamId : Int): TeamResponse = service.getTeam(teamId)

    interface Service {
        @Headers("X-Auth-Token:65e0452590374053a107528fbbfdb939")
        @GET("teams")
        suspend fun getTeams(): TeamsResponse

        @GET("team/{teamId}")
        suspend fun getTeam(@Path("teamId") teamId: Int): TeamResponse
    }

    companion object {
        const val BASE_URL = "https://api.football-data.org/v4/"
    }
}