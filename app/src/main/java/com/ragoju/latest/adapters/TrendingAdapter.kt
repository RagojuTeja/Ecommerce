package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.TrendingItemViewBinding

class TrendingAdapter(private val trendList : ArrayList<HomeData>, context: Context) :
    RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>(){

    var onItemClick : ((HomeData)-> Unit)? = null

    val context : Context = context

    inner class TrendingViewHolder(val binding: TrendingItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAdapter.TrendingViewHolder {
        return TrendingViewHolder(TrendingItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val trendData = trendList[position]
        holder.binding.apply {
            val product: HomeData = trendList[position]
            productBrandNameTrending.text = product.Name2
            productNameTrending.text = product.Name
            productPriceTrending.text = "$"+product.Price
            productRatingTrending.rating = product.rating


            Glide.with(context)
                .load(trendData.Image)
                .placeholder(R.drawable.shoe_new)
                .into(trendingimgTrending)

            holder.itemView.setOnClickListener {
                onItemClick?.invoke(trendData)
            }
        }
    }
    override fun getItemCount(): Int {
        return trendList.size
    }
}