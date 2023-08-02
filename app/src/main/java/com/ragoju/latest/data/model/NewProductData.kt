package com.ragoju.latest.data.model

import android.os.Parcel
import android.os.Parcelable

data class NewProductData(

    val id: String?,
    val title: String?,
    val attribute: String?,
    val currency: String?,
    val price: String?,
    val image: Int,
    val categoryId: String?,
    val description: String?,
    val discount: String?,
    val quantity : String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(attribute)
        parcel.writeString(currency)
        parcel.writeString(price)
        parcel.writeInt(image)
        parcel.writeString(categoryId)
        parcel.writeString(description)
        parcel.writeString(discount)
        parcel.writeString(quantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewProductData> {
        override fun createFromParcel(parcel: Parcel): NewProductData {
            return NewProductData(parcel)
        }

        override fun newArray(size: Int): Array<NewProductData?> {
            return arrayOfNulls(size)
        }
    }
}
