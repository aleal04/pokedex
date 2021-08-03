package com.project.pokedex.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokeTrainer (@PrimaryKey val trainerName: String, val gender: String)