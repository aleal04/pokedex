package com.project.pokedex.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.project.pokedex.db.dao.PokemonFavoritesDAO
import com.project.pokedex.db.entity.PokeFavorite

class PokemonFavoritesRepository(private val pokemonFavDAO: PokemonFavoritesDAO) {


    //val allPokeFavorites: LiveData<List<PokeFavorite>> = pokemonFavDAO.getPokemonFavorites(pokeTrainer)

    fun getPokemonFavorites(pokeTrainer :String): LiveData<List<PokeFavorite>> = pokemonFavDAO.getPokemonFavorites(pokeTrainer)

    @WorkerThread
    suspend fun insert(pokemonFavorite: PokeFavorite){
        pokemonFavDAO.insertPokemonFavorite(pokemonFavorite)
    }

    @WorkerThread
    suspend fun delete(pokeNumber: Int){
        pokemonFavDAO.deletePokemonFavorite(pokeNumber)
    }

    @WorkerThread
    fun existPokemon(pokeNumber: Int){
        pokemonFavDAO.isRowIsExist(pokeNumber)
    }
}