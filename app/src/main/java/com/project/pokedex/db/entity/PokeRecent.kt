package com.project.pokedex.db.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokeRecent (@PrimaryKey val pokeNumber: Int, val pokeName: String , val trainer: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(pokeNumber)
        parcel.writeString(pokeName)
        parcel.writeString(trainer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokeRecent> {
        override fun createFromParcel(parcel: Parcel): PokeRecent {
            return PokeRecent(parcel)
        }

        override fun newArray(size: Int): Array<PokeRecent?> {
            return arrayOfNulls(size)
        }
    }
}