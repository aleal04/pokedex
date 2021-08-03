package com.project.pokedex.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.project.pokedex.db.PokemonRecentsDB
import com.project.pokedex.db.entity.PokeRecent
import com.project.pokedex.repository.PokemonRecentsRepository


class ListPokemonRecentViewModel (application: Application) : AndroidViewModel(application) {

    private val db = PokemonRecentsDB.getPokemonRecentsDataBase(application.applicationContext)
    private val repository = PokemonRecentsRepository(db.pokemonRecentDao())

    //Show
    fun getPokemonRecentsByTrainer(trainer: String): LiveData<List<PokeRecent>> = repository.getPokemonRecents(trainer)
}