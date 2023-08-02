package com.ragoju.latest.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.R
import com.ragoju.latest.data.model.NewProductData
import com.ragoju.latest.databinding.RowNewHomeProductsBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class NewProductAdapter(private val newProductList: ArrayList<NewProductData>) :
    RecyclerView.Adapter<NewProductAdapter.NewProductViewHolder>() {


    lateinit var _quantity: String
    lateinit var _price:kotlin.String
    lateinit var _attribute:kotlin.String
    lateinit var _subtotal:kotlin.String

    var onItemClick : ((NewProductData)-> Unit)? = null

    inner class NewProductViewHolder(val binding: RowNewHomeProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewProductViewHolder {
        return NewProductViewHolder(
            RowNewHomeProductsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewProductViewHolder, position: Int) {
        holder.binding.apply {
            val productData = newProductList[position]
            productImage.setImageResource(productData.image)
            productTitle.text = productData.title
            productAttribute.text = productData.attribute
            productCurrency.text = productData.currency
            productPrice.text = productData.price



            Picasso.get().load(productData.image)
                .error(R.drawable.banana)
                .into(holder.binding.productImage, object : Callback {
                    override fun onSuccess() {
                        holder.binding.progressbar.setVisibility(View.GONE)
                    }

                    override fun onError(e: Exception) {
                        Log.d("Error : ", e.message!!)
                    }
                })

            if (!newProductList.isEmpty()) {
                for (i in newProductList.indices) {
                    if (newProductList.get(i).id.contentEquals(productData.id)) {
                        holder.binding.shopNow.setVisibility(View.GONE)
                        holder.binding.quantityLl.setVisibility(View.VISIBLE)
                        holder.binding.quantity.setText(newProductList.get(i).quantity)
                    }
                }
            }



                    holder.itemView.setOnClickListener {
                onItemClick?.invoke(productData)
            }
        }


    }

    override fun getItemCount(): Int {
        return newProductList.size
    }
}


