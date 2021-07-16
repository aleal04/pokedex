package com.project.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.pokedex.network.RetrofitProvider
import com.project.pokedex.network.models.PokeApiResponse
import com.project.pokedex.network.models.PokeResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonAllViewModel : ViewModel() {

    private val retrofitProvider = RetrofitProvider()

    private val _pokemonAllLiveData = MutableLiveData<List<PokeResult>>()
    val pokemonAllLiveData: LiveData<List<PokeResult>> = _pokemonAllLiveData

    fun getPokemonList( offset: Int = 0){

        val call = retrofitProvider.getApiService().getPokemonList(10 , offset)

        call.enqueue(object: Callback<PokeApiResponse>{
            override fun onResponse(
                call: Call<PokeApiResponse>,
                response: Response<PokeApiResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.results?.let{
                        val pokemons: List<PokeResult> = it.map{ list->
                            PokeResult(
                                name = list.name,
                                number = getNumber(list.url) ,
                                url = list.url
                            )
                        }
                        _pokemonAllLiveData.postValue(pokemons)
                    }
                }
            }

            override fun onFailure(call: Call<PokeApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }

    fun getNumber(urlParts: String): Int{
        val urlSplit: List<String> = urlParts.split("/")
        return urlSplit[6].toInt()
    }



}