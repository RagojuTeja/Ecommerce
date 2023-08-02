package com.ragoju.latest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.HomeCgItemviewBinding
import com.ragoju.latest.utils.RvData


class HomeCategoryAdapter( private val categoryList: ArrayList<HomeData>) :
    RecyclerView.Adapter<HomeCategoryAdapter.HomeCgViewHolder>() {


    inner class HomeCgViewHolder(val binding: HomeCgItemviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCgViewHolder {
        return HomeCgViewHolder(HomeCgItemviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeCgViewHolder, position: Int) {
        holder.binding.apply {
            val categoryData = categoryList[position]
            homeCgImageView.setImageResource(categoryData.Image)
            homeCgTextView.text = categoryData.Name

//            holder.itemView.setOnClickListener {
//                onItemClick?.invoke(CategoryData)
//            }


        }
    }

//        holder.itemView.setOnClickListener {
//
//            val activity = it.context as?AppCompatActivity
//
//            if(position == 0) {
//
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.add(R.id.frame_bottom, furnitureFragment)?.addToBackStack("null")?.commit()
//
////                activity?.getSupportFragmentManager()!!.beginTransaction().remove(furnitureFragment).commit();
//
//            }
//            if (position == 2) {
//
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.frame_bottom, footwearFragment)?.addToBackStack(null)?.commit()
//            }
//            if (position == 3) {
//
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.frame_bottom, dtdTrendingOfrFragment)?.addToBackStack(null)?.commit()
//
//            }
//            if (position == 4) {
//
//               val intent = Intent(context, AllCategoriesScreen::class.java)
//                activity?.startActivity(intent)
//
//            }
//        }
//    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}