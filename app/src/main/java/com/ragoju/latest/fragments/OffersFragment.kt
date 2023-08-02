package com.ragoju.latest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.adapters.OffersAdapter
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.FragmentOffersBinding
import com.ragoju.latest.utils.RvData


class OffersFragment : Fragment() {

    private lateinit var binding : FragmentOffersBinding

    private lateinit var offersRV : RecyclerView
    private lateinit var offersAdapter: OffersAdapter
    private lateinit var rvData: RvData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentOffersBinding.inflate(layoutInflater)

        offersRV = binding.offersRecyclerview
        rvData  = RvData()

        offerProduct()

        return binding.root
    }

    fun offerProduct() {

        offersAdapter = OffersAdapter(rvData.getOffersList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        offersRV.setLayoutManager(mLayoutManager)
        offersRV.setItemAnimator(DefaultItemAnimator())
        offersRV.setAdapter(offersAdapter)
    }
}