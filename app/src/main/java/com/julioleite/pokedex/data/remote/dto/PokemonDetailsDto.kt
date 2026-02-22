package com.julioleite.pokedex.data.remote.dto

import com.julioleite.pokedex.domain.model.PokemonDetail
import com.julioleite.pokedex.domain.model.PokemonStat
import com.julioleite.pokedex.domain.model.PokemonType
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PokemonDetailDto(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeSlotDto>,
    val stats: List<StatSlotDto>,
    val abilities: List<AbilitySlotDto>,
    val cries: CriesDto,
    val sprites: SpritesDto
)

@Serializable
data class AbilitySlotDto(
    val ability: AbilityDto,
    @SerialName("is_hidden") val isHidden: Boolean
)

@Serializable
data class AbilityDto(val name: String)

@Serializable
data class CriesDto(val latest: String)

@Serializable
data class TypeSlotDto(
    val slot: Int,
    val type: TypeDto
)

@Serializable
data class TypeDto(val name: String)

@Serializable
data class StatSlotDto(
    @SerialName("base_stat") val baseStat: Int,
    val stat: StatDto
)

@Serializable
data class StatDto(val name: String)

@Serializable
data class SpritesDto(
    val other: OtherSpritesDto
)

@Serializable
data class OtherSpritesDto(
    @SerialName("official-artwork") val officialArtwork: OfficialArtworkDto
)

@Serializable
data class OfficialArtworkDto(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String
)

fun PokemonDetailDto.toPokemonDetail(): PokemonDetail {
    return PokemonDetail(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        height = "${height / 10.0} m",
        weight = "${weight / 10.0} kg",
        imageUrl = sprites.other.officialArtwork.frontDefault,
        shinyImageUrl = sprites.other.officialArtwork.frontShiny,
        types = types.map { PokemonType.fromString(it.type.name) },
        abilities = abilities.map { it.ability.name.replace("-", " ").replaceFirstChar { char -> char.uppercase() } },
        stats = stats.map {
            PokemonStat(
                name = parseStatName(it.stat.name),
                value = it.baseStat,
                percentage = it.baseStat / 255f
            )
        }
    )
}

private fun parseStatName(stat: String): String {
    return when (stat.lowercase()) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SP.ATK"
        "special-defense" -> "SP.DEF"
        "speed" -> "SPD"
        else -> stat.uppercase()
    }
}