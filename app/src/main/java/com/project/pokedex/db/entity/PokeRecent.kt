package com.project.pokedex.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokeRecent (@PrimaryKey val pokeNumber: Int, val pokeName: String , val trainer: String)