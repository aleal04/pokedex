package com.project.pokedex.network.models

import android.os.Parcel
import android.os.Parcelable

data class PokeInfoDetail (
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites ,
    val types : List<Types>,
    val abilities : List<ability>,
    val stats: List<StatsDescription>
)
data class Sprites(
    val front_default: String? ,
    val front_shiny: String? ,
    val front_female: String? ,
    val front_shiny_female: String? ,
)

data class Types(
    val slot: Int ,
    val type : DescrpType ,
)

data class DescrpType(
    val name: String,
)

data class ability(
    val ability: abilityName,
)

data class abilityName(
    val name: String?,
)

data class StatsDescription(
    val base_stat: Int ,
    val stat : StatsName ,

)

data class StatsName(
    val name: String?,
)



