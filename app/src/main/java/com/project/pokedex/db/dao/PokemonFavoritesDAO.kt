package com.project.pokedex.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.pokedex.db.entity.PokeFavorite

@Dao
interface PokemonFavoritesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonFavorite(pokemonFavorite: PokeFavorite)

    @Query("SELECT * FROM PokeFavorite WHERE trainer = :trainer")
    fun getPokemonFavorites(trainer: String): LiveData<List<PokeFavorite>>

    @Query("DELETE FROM PokeFavorite WHERE pokeNumber = :pokeID")
    suspend fun deletePokemonFavorite(pokeID: Int)

    @Query("SELECT EXISTS(SELECT * FROM PokeFavorite WHERE pokeNumber = :pokeNumber)")
    fun isRowIsExist(pokeNumber : Int) : Boolean
}