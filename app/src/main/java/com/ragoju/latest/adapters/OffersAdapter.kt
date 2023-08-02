package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.OffersItemViewBinding

class OffersAdapter(private val offerList: ArrayList<HomeData>, val context: Context) :
    RecyclerView.Adapter<OffersAdapter.OfferViewHolder>() {


    inner class OfferViewHolder(val binding: OffersItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersAdapter.OfferViewHolder {
        return OfferViewHolder(OffersItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.binding.apply {
            val offerData = offerList[position]
            offerTextview.text = offerData.Name

            Glide.with(context)
                .load(offerData.Image)
                .placeholder(R.drawable.sale)
        }
    }

    override fun getItemCount(): Int {
        return offerList.size
    }
}