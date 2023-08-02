package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.TopDealsItemviewBinding
import com.ragoju.latest.databinding.TrendingItemViewBinding

class TopDealsAdapter(private val topdealList : ArrayList<HomeData>, context: Context) :
    RecyclerView.Adapter<TopDealsAdapter.TopDealsViewHolder>(){

    var onItemClick : ((HomeData)-> Unit)? = null

    val context : Context = context

    inner class TopDealsViewHolder(val binding: TopDealsItemviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDealsAdapter.TopDealsViewHolder {
        return TopDealsViewHolder(TopDealsItemviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: TopDealsViewHolder, position: Int) {
        val topDealData = topdealList[position]
        holder.binding.apply {
            bestsellTextViewTopdeals.text = topDealData.Name
            bestsellPriceTopdeals.text = "$"+topDealData.Price
            productRatingTopdeals.rating = topDealData.rating

            Glide.with(context)
                .load(topDealData.Image)
                .placeholder(R.drawable.headphone)
                .into(bestsellImageViewTopdeals)



            holder.itemView.setOnClickListener {
                onItemClick?.invoke(topDealData)
            }
        }
    }

    override fun getItemCount(): Int {
        return topdealList.size
    }
}