package com.julioleite.pokedex.data.remote

import com.julioleite.pokedex.common.Constants
import com.julioleite.pokedex.data.remote.dto.PokemonDetailDto
import com.julioleite.pokedex.data.remote.dto.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("/pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = Constants.PAGE_SIZE,
        @Query("offset") offset: Int = 0
    ): PokemonListDto

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(
        @Path("id") id: Int
    ) : PokemonDetailDto

}