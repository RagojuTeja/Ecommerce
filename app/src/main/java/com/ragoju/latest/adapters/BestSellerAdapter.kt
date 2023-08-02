package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.BestsellItemViewBinding
import com.ragoju.latest.databinding.DealsItemViewBinding

class BestSellerAdapter(private val bestList: ArrayList<HomeData>, context: Context) :
    RecyclerView.Adapter<BestSellerAdapter.BestViewHolder>() {

    val context : Context = context


    inner class BestViewHolder(val binding: BestsellItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerAdapter.BestViewHolder {
        return BestViewHolder(
            BestsellItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: BestViewHolder, position: Int) {
        holder.binding.apply {
            val bestData = bestList[position]
            productBrandNameBestseller.text = bestData.Name
            productNameBestseller.text = bestData.Name2
            productPriceBestseller.text = "$"+bestData.Price
            productRatingBestseller.rating = bestData.rating

            Glide.with(context)
                .load(bestData.Image)
                .placeholder(R.drawable.bn)
        }
    }


            override fun getItemCount(): Int {
        return bestList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val productImage_singleProduct: ImageView = itemView.findViewById(R.id.productImage_singleProduct)
        val productAddToFav_singleProduct: ImageView = itemView.findViewById(R.id.productAddToFav_singleProduct)
        val productRating_singleProduct: RatingBar = itemView.findViewById(R.id.productRating_singleProduct)
        val productBrandName_singleProduct: TextView = itemView.findViewById(R.id.productBrandName_singleProduct)
        val discountTv_singleProduct: TextView = itemView.findViewById(R.id.discountTv_singleProduct)
        val productName_singleProduct: TextView = itemView.findViewById(R.id.productName_singleProduct)
        val productPrice_singleProduct: TextView = itemView.findViewById(R.id.productPrice_singleProduct)
        val discount_singleProduct = itemView.findViewById<LinearLayout>(R.id.discount_singleProduct)


    }
}
