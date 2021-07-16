package com.project.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.pokedex.network.RetrofitProvider
import com.project.pokedex.network.models.PokeInfoDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class PokemonInfoViewModel : ViewModel() {
    private val retrofitProvider = RetrofitProvider()


    private val _pokemonInfo= MutableLiveData<PokeInfoDetail>()
    val pokemonInfo: LiveData<PokeInfoDetail> = _pokemonInfo

    fun getPokemonDetail(id: Int = 1){
        val call = retrofitProvider.getApiService().getPokemonInfo(id)
        call.enqueue(object : Callback<PokeInfoDetail> {
            override fun onResponse(
                call: Call<PokeInfoDetail>,
                response: Response<PokeInfoDetail>
            ) {
                response.body()?.let { pokemon->
                    _pokemonInfo.postValue(pokemon)
                }
            }
            override fun onFailure(call: Call<PokeInfoDetail>, t: Throwable) {
                call.cancel()
            }
        })
    }
}
