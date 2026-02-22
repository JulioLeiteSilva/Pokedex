package com.julioleite.pokedex.domain.model

data class PokemonDetail(
    val id: Int,
    val name: String,
    val height: String,
    val weight: String,
    val imageUrl: String,
    val shinyImageUrl: String,
    val types: List<PokemonType>,
    val stats: List<PokemonStat>,
    val abilities: List<String>
)

data class PokemonStat(
    val name: String,
    val value: Int,
    val percentage: Float
)
