package com.project.pokedex.viewmodels

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.pokedex.db.PokemonFavoritesDB
import com.project.pokedex.network.RetrofitProvider
import com.project.pokedex.network.models.PokeInfoDetail
import com.project.pokedex.repository.PokemonFavoritesRepository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class PokemonInfoViewModel (application: Application): AndroidViewModel(application) {

    private val db = PokemonFavoritesDB.getPokemonFavoriteDataBase(application.applicationContext)
    private val repository = PokemonFavoritesRepository(db.pokemonFavoriteDAO())

    private val retrofitProvider = RetrofitProvider()

    private val _pokemonInfo= MutableLiveData<PokeInfoDetail>()
    val pokemonInfo: LiveData<PokeInfoDetail> = _pokemonInfo

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _serverError = MutableLiveData<Boolean>()
    val serverError: LiveData<Boolean> = _serverError


    fun getPokemonDetail(id: Int = 1){
        _isLoading.postValue(true)
        val call = retrofitProvider.getApiService().getPokemonInfo(id)
        call.enqueue(object : Callback<PokeInfoDetail> {
            override fun onResponse(
                call: Call<PokeInfoDetail>,
                response: Response<PokeInfoDetail>
            ) {
                _isLoading.postValue(false)
                if(response.isSuccessful){
                    response.body()?.let { pokemon->
                        _pokemonInfo.postValue(pokemon)
                    }
                }
                else{
                    _serverError.postValue(true)
                }
            }
            override fun onFailure(call: Call<PokeInfoDetail>, t: Throwable) {
                _serverError.postValue(true)
                _isLoading.postValue(false)
                call.cancel()
            }
        })
    }

    fun isPokemonFavorite(pokemonID : Int){
        repository.existPokemon(pokemonID)
    }

    suspend fun ifExistPokemon(pokeNumber: Int){
        return repository.existPokemon(pokeNumber)
    }
}
