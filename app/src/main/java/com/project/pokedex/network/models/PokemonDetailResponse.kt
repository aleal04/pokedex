package com.project.pokedex.network.models

data class PokeInfoDetail (
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)

data class Sprites(
    val fronDefault: String? ,
    val frontShiny: String?
)



