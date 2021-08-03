package com.project.pokedex.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.project.pokedex.db.PokemonFavoritesDB
import com.project.pokedex.db.entity.PokeFavorite
import com.project.pokedex.repository.PokemonFavoritesRepository
import kotlinx.coroutines.launch

class ListPokemonFavoritesViewModel (application: Application) : AndroidViewModel(application) {
    private val db = PokemonFavoritesDB.getPokemonFavoriteDataBase(application.applicationContext)
    private val repository = PokemonFavoritesRepository(db.pokemonFavoriteDAO())

    //Show
    fun fetchPokeFavorites(pokeTrainer: String): LiveData<List<PokeFavorite>> = repository.getPokemonFavorites(pokeTrainer)

    //Delete
    fun deletePokeFavorites(pokeNumber: Int ) = viewModelScope.launch {
        repository.delete(pokeNumber)
    }
}