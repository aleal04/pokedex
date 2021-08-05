package com.project.pokedex.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.project.pokedex.db.entity.PokeRecent


@Dao
interface PokemonRecentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonRecent(pokemonRecent: PokeRecent)

    @Query("SELECT * FROM PokeRecent WHERE trainer = :trainer")
    fun getPokemonRecents(trainer: String): LiveData<List<PokeRecent>>

    @Query("DELETE FROM PokeRecent WHERE trainer = :trainer")
    suspend fun deletePokemonRecents(trainer: String)

}