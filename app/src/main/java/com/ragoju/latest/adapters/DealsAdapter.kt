package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.DealsItemViewBinding

class DealsAdapter(private val dealsList: ArrayList<HomeData>, context: Context) :
    RecyclerView.Adapter<DealsAdapter.DealsViewHolder>() {

    val context : Context = context

    var onItemClick : ((HomeData)-> Unit)? = null


    inner class DealsViewHolder(val binding: DealsItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsAdapter.DealsViewHolder {
        return DealsViewHolder(DealsItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        holder.binding.apply {
            val dealsData = dealsList[position]
//            delasImage.setImageResource(dealsData.Image)
            dealsText.text = dealsData.Name

            Glide.with(context)
                .load(dealsData.Image)
                .placeholder(R.drawable.vegetables)


            holder.itemView.setOnClickListener {
                onItemClick?.invoke(dealsData)
            }

//
//        val dtdTrendingOfrFragment = DtdTrendingOfrFragment()
//
//        holder.itemView.setOnClickListener {
//
//            val activity = it.context as? AppCompatActivity
//
//            activity?.supportFragmentManager?.beginTransaction()
//                ?.replace(R.id.frame_bottom, dtdTrendingOfrFragment)?.addToBackStack(null)?.commit()
//        }
        }
    }

    override fun getItemCount(): Int {
        return dealsList.size
    }
}