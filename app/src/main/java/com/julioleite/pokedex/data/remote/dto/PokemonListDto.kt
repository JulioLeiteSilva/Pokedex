package com.julioleite.pokedex.data.remote.dto
import com.julioleite.pokedex.common.Constants
import com.julioleite.pokedex.domain.model.PokemonListItem
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonEntryDto>
)

@Serializable
data class PokemonEntryDto(
    val name: String,
    val url: String
)

fun PokemonEntryDto.toPokemonListItem(): PokemonListItem {
    val id = if (url.endsWith("/")) {
        url.dropLast(1).takeLastWhile {it.isDigit()}
    } else {
        url.takeLastWhile {it.isDigit()}
    }.toInt()

    return PokemonListItem(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = "${Constants.IMAGE_URL_BASE}$id.png}"
    )
}