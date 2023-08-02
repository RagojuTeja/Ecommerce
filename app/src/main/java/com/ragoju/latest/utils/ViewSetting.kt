package com.ragoju.latest.utils

import android.app.Activity
import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.R
import com.ragoju.latest.adapters.HomeCategoryAdapter
import com.ragoju.latest.data.model.HomeData


class ViewSetting(val activity: Activity){

   val recyclerViewNews = activity.findViewById<RecyclerView>(R.id.home_cg_recycler)



    fun fnjf (context: Context) {

//        val newsList = RvData.getCategoryList()
//        val newsAdapter = HomeCategoryAdapter(newsList as ArrayList<HomeData>)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        recyclerViewNews.adapter = newsAdapter
        recyclerViewNews.layoutManager = layoutManager
        recyclerViewNews.setHasFixedSize(true)


    }


}