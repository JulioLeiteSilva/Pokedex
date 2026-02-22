package com.julioleite.pokedex.domain.model

import androidx.compose.ui.graphics.Color
enum class PokemonType(val typeName: String, val color: Color) {
    GRASS("grass", Color(0xFF74CB48)),
    FIRE("fire", Color(0xFFF57D31)),
    WATER("water", Color(0xFF6493EB)),
    BUG("bug", Color(0xFFA7B723)),
    NORMAL("normal", Color(0xFFAAA67F)),
    POISON("poison", Color(0xFFA43E9E)),
    ELECTRIC("electric", Color(0xFFF9CF30)),
    GROUND("ground", Color(0xFFDEC16B)),
    FAIRY("fairy", Color(0xFFE69EAC)),
    FIGHTING("fighting", Color(0xFFC12239)),
    PSYCHIC("psychic", Color(0xFFFB5584)),
    ROCK("rock", Color(0xFFB69E31)),
    GHOST("ghost", Color(0xFF70559B)),
    ICE("ice", Color(0xFF9AD6DF)),
    DRAGON("dragon", Color(0xFF7037FF)),
    DARK("dark", Color(0xFF75574C)),
    STEEL("steel", Color(0xFFB7B7CE)),
    FLYING("flying", Color(0xFFA891EC)),
    STELLAR("stellar", Color(0xFF40B5A5)),
    UNKNOWN("unknown", Color(0xFF68A090));

    companion object {
        fun fromString(type: String): PokemonType {
            return entries.find { it.typeName == type.lowercase() } ?: UNKNOWN
        }
    }
}