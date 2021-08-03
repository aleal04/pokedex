package com.project.pokedex.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.pokedex.db.dao.PokemonFavoritesDAO
import com.project.pokedex.db.entity.PokeFavorite

@Database(entities = [PokeFavorite::class], version = 1, exportSchema = false)

abstract class PokemonFavoritesDB : RoomDatabase() {
    abstract fun pokemonFavoriteDAO(): PokemonFavoritesDAO

    companion object{
        @Volatile
        private var INSTANCE: PokemonFavoritesDB? = null

        fun getPokemonFavoriteDataBase(context: Context):PokemonFavoritesDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext ,
                    PokemonFavoritesDB::class.java ,
                    "POKEMON FAVORITES"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}