package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.NotificationItemViewBinding

class NotificationAdapter(private val notificationList: ArrayList<HomeData>, val context: Context) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {


    inner class NotificationViewHolder(val binding: NotificationItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationAdapter.NotificationViewHolder {
        return NotificationViewHolder(NotificationItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.binding.apply {
            val notificationData = notificationList[position]
            notificText2.text = notificationData.Name
            notificTxt4.text  = notificationData.Name2

            Glide.with(context)
                .load(notificationData.Image)
                .placeholder(R.drawable.sale)
        }
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
}