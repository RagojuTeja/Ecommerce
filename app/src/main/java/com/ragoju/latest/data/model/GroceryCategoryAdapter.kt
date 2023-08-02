package com.ragoju.latest.data.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.databinding.RowHomeCategoryBinding

/**
 * Grocery App
 * https://github.com/quintuslabs/GroceryStore
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

class GroceryCategoryAdapter(private val categorieList: ArrayList<GroceryCategorieData>) :
        RecyclerView.Adapter<GroceryCategoryAdapter.GroceryCategorieViewHolder>() {

    var onItemClick : ((GroceryCategorieData)-> Unit)? = null

        inner class GroceryCategorieViewHolder(val binding: RowHomeCategoryBinding) :
            RecyclerView.ViewHolder(binding.root) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryCategorieViewHolder {
            return GroceryCategorieViewHolder(
                RowHomeCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: GroceryCategorieViewHolder, position: Int) {
            holder.binding.apply {
                val gCategoryData = categorieList[position]
                categoryTitle.text = gCategoryData.Name

                holder.itemView.setOnClickListener {
                    onItemClick?.invoke(gCategoryData)
                }


            }
        }

        override fun getItemCount(): Int {
            return categorieList.size
        }
    }