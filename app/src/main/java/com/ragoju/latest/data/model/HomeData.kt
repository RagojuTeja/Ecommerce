package com.ragoju.latest.data.model

import android.os.Parcel
import android.os.Parcelable

data class HomeData(val Image: Int,
                    val Name: String,
                    val Price: String,
                    val Offer: String,
                    val Discount: String,
                    val Name2: String,
                    val productHave:Boolean = false,
                    val rating : Float = 0.0F) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Image)
        parcel.writeString(Name)
        parcel.writeString(Price)
        parcel.writeString(Offer)
        parcel.writeString(Discount)
        parcel.writeString(Name2)
        parcel.writeByte(if (productHave) 1 else 0)
        parcel.writeFloat(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeData> {
        override fun createFromParcel(parcel: Parcel): HomeData {
            return HomeData(parcel)
        }

        override fun newArray(size: Int): Array<HomeData?> {
            return arrayOfNulls(size)
        }
    }
}

