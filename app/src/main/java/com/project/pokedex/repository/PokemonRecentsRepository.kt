package com.project.pokedex.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.project.pokedex.db.dao.PokemonRecentDAO
import com.project.pokedex.db.entity.PokeRecent

class PokemonRecentsRepository (private val pokemonRecDao: PokemonRecentDAO) {
    //val allPokemonRecents: LiveData<List<PokeRecent>> = pokemonRecDao.getPokemonRecents()

    fun getPokemonRecents(trainer: String) : LiveData<List<PokeRecent>> = pokemonRecDao.getPokemonRecents(trainer)

    @WorkerThread
    suspend fun insert(pokemonRecent: PokeRecent){
        pokemonRecDao.insertPokemonRecent(pokemonRecent)
    }

    @WorkerThread
    suspend fun delete(trainer: String){
        pokemonRecDao.deletePokemonRecents(trainer)
    }

}