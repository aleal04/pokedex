package com.project.pokedex.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.pokedex.db.dao.PokemonRecentDAO
import com.project.pokedex.db.entity.PokeRecent

@Database(entities = [PokeRecent::class], version = 1, exportSchema = false)
abstract class PokemonRecentsDB : RoomDatabase() {
    abstract fun pokemonRecentDao(): PokemonRecentDAO

    companion object{
        @Volatile
        private var INSTANCE: PokemonRecentsDB? = null

        fun getPokemonRecentsDataBase(context: Context):PokemonRecentsDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext ,
                    PokemonRecentsDB::class.java ,
                    "POKEMON RECENTS"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}