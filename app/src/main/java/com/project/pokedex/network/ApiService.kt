package com.project.pokedex.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.project.pokedex.network.models.PokeApiResponse
import com.project.pokedex.network.models.PokeInfoDetail
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int , @Query("offset") offset: Int): Call<PokeApiResponse>

    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id:Int): Call<PokeInfoDetail>
}