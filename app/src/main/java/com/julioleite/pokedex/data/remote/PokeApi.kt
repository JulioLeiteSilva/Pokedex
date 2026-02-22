package com.julioleite.pokedex.data.remote

import com.julioleite.pokedex.data.remote.dto.PokemonListDto
import com.julioleite.pokedex.common.Constants
import retrofit2.http.GET

interface PokeApi {

    @GET("/pokemon?limit=${Constants.PAGE_SIZE}$&offset=0")
    suspend fun getPokemonList(): PokemonListDto
}