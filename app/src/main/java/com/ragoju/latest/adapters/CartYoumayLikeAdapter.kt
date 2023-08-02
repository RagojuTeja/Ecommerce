package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.CartYoumaylikeItemviewBinding

class CartYoumayLikeAdapter(private val cartlikeList: ArrayList<HomeData>, val context: Context) :
    RecyclerView.Adapter<CartYoumayLikeAdapter.CartYoumayLikeViewHolder>() {


    inner class CartYoumayLikeViewHolder(val binding: CartYoumaylikeItemviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartYoumayLikeAdapter.CartYoumayLikeViewHolder {
        return CartYoumayLikeViewHolder(
            CartYoumaylikeItemviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: CartYoumayLikeViewHolder, position: Int) {
        holder.binding.apply {
            val dealsData = cartlikeList[position]
            productsTextView.text = dealsData.Name
            priceTv.text = dealsData.Price

            Glide.with(context)
                .load(dealsData.Image)
                .placeholder(R.drawable.vegetables)
                .into(productsImageViewItem)
        }
    }

    override fun getItemCount(): Int {
        return cartlikeList.size
    }
}