package com.project.pokedex.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.pokedex.db.PokemonFavoritesDB
import com.project.pokedex.db.entity.PokeFavorite
import com.project.pokedex.repository.PokemonFavoritesRepository
import kotlinx.coroutines.launch

class StorePokemonFavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: PokemonFavoritesRepository

    init {
        val db = PokemonFavoritesDB.getPokemonFavoriteDataBase(application.applicationContext)
        repository = PokemonFavoritesRepository(db.pokemonFavoriteDAO())
    }

    fun insert(pokeNumber: Int , pokeName: String , trainer: String) = viewModelScope.launch {
        repository.insert(PokeFavorite(pokeNumber , pokeName , trainer))
    }
}