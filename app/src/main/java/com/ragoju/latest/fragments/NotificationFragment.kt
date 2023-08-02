package com.ragoju.latest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.adapters.NotificationAdapter
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.FragmentNotificationBinding
import com.ragoju.latest.utils.RvData


class NotificationFragment : Fragment() {

    private lateinit var binding : FragmentNotificationBinding

    private lateinit var notificationRV : RecyclerView
    private lateinit var rvData : RvData
    private lateinit var notificationAdapter: NotificationAdapter

    private lateinit var notificationList: List<HomeData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(layoutInflater)

        notificationRV = binding.notificationRV

        rvData = RvData()


        notificationList()




        return binding.root
    }

    private fun notificationList() {

        notificationAdapter = NotificationAdapter(rvData.getNotificationList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        notificationRV.layoutManager = mLayoutManager
        notificationRV.itemAnimator = DefaultItemAnimator()
        notificationRV.adapter = notificationAdapter
    }
}