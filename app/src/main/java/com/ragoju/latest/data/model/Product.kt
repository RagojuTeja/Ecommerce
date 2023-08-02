package com.ragoju.latest.data.model

import android.accessibilityservice.AccessibilityGestureEvent.CREATOR
import android.accounts.AccountAuthenticatorResponse.CREATOR
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class BaseClass(
    @SerializedName("products") val products: List<Product>? = null,
    @SerializedName("total") val total: Int? = null,
    @SerializedName("skip") val skip: Int? = null,
    @SerializedName("limit") val limit: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Product.CREATOR),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(products)
        parcel.writeValue(total)
        parcel.writeValue(skip)
        parcel.writeValue(limit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BaseClass> {
        override fun createFromParcel(parcel: Parcel): BaseClass {
            return BaseClass(parcel)
        }

        override fun newArray(size: Int): Array<BaseClass?> {
            return arrayOfNulls(size)
        }
    }
}


data class Product(
    @SerializedName("id") val id: Int? = null,//named as productId, productName... and productList --> products
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("discountPercentage") val discountPercentage: Double? = null,
    @SerializedName("rating") val rating: Double? = null,
    @SerializedName("stock") val stock: Int? = null,
    @SerializedName("brand") val brand: String? = null,
    @SerializedName("category") val category: String? = null,
    @SerializedName("thumbnail") val thumbnail: String? = null,
    @SerializedName("images") val images: List<String>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeValue(price)
        parcel.writeValue(discountPercentage)
        parcel.writeValue(rating)
        parcel.writeValue(stock)
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(thumbnail)
        parcel.writeStringList(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}