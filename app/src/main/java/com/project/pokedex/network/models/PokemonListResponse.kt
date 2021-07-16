package com.project.pokedex.network.models

import android.os.Parcel
import android.os.Parcelable

data class PokeApiResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokeResult>
)

data class PokeResult(
    val name: String,
    val url: String,
    val number: Int ,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeInt(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokeResult> {
        override fun createFromParcel(parcel: Parcel): PokeResult {
            return PokeResult(parcel)
        }

        override fun newArray(size: Int): Array<PokeResult?> {
            return arrayOfNulls(size)
        }
    }
}



