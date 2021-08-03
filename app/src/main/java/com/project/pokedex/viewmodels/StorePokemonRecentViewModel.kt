package com.project.pokedex.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.pokedex.db.PokemonRecentsDB
import com.project.pokedex.db.entity.PokeRecent
import com.project.pokedex.repository.PokemonRecentsRepository
import kotlinx.coroutines.launch


class StorePokemonRecentViewModel (application: Application) : AndroidViewModel(application) {
    private var repository: PokemonRecentsRepository

    init {
        val db = PokemonRecentsDB.getPokemonRecentsDataBase(application.applicationContext)
        repository = PokemonRecentsRepository(db.pokemonRecentDao())
    }

    fun insert(pokeNumber: Int , pokeName: String , trainer: String = "Dummy") = viewModelScope.launch {
        repository.insert(PokeRecent(pokeNumber , pokeName , trainer))
    }
}