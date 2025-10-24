package com.unsoed.responsi1mobileh1d023114.data.network

import com.unsoed.responsi1mobileh1d023114.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    @GET("teams/{id}")
    suspend fun getTeamDetails(
        @Path("id") teamId: Int,
        @Header("X-Auth-Token") token: String
    ): Response<TeamResponse>
}
