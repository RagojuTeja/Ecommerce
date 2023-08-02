package com.ragoju.latest.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.adapters.*
import com.ragoju.latest.data.ProductEntity
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.FragmentCartBinding
import com.ragoju.latest.utils.CartViewModel
import com.ragoju.latest.utils.RvData


class CartFragment : Fragment(), CartItemClickAdapter {


    private lateinit var binding: FragmentCartBinding

    lateinit var proceedBtn : Button
    lateinit var rvData : RvData

    lateinit var cartRecView: RecyclerView
    lateinit var cartYmlRv : RecyclerView
    lateinit var cartAdapter: CartAdapter
    lateinit var cartYoumayLikeAdapter: CartYoumayLikeAdapter
    lateinit var totalPriceBagFrag: TextView
    lateinit var ItemData: ArrayList<ProductEntity>
    var sum:Int = 0

    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentCartBinding.inflate(layoutInflater)

        cartRecView = binding.cartRecyclerview
        totalPriceBagFrag = binding.totalpriceTxt
        proceedBtn = binding.proceedBTN
        cartYmlRv = binding.cartRvHZ

        ItemData = arrayListOf()
        rvData = RvData()


        cartRecView.layoutManager = LinearLayoutManager(context)
        cartAdapter = CartAdapter(activity as Context, this )
        cartRecView.adapter = cartAdapter



        cartYoumayLikeAdapter = CartYoumayLikeAdapter(rvData.getCartYMLList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        cartYmlRv.setLayoutManager(mLayoutManager)
        cartYmlRv.setItemAnimator(DefaultItemAnimator())
        cartYmlRv.setAdapter(cartYoumayLikeAdapter)




        cartViewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)

        cartViewModel.allproducts.observe(viewLifecycleOwner) { List ->
            List?.let { cartAdapter.updateList(it)
                ItemData.clear()
                sum = 0
                ItemData.addAll(it)
            }


            ItemData.forEach {
                sum += it.price
            }
            totalPriceBagFrag.text = "$" + sum
        }


        return binding.root

    }

    override fun onItemDeleteClick(product: ProductEntity) {
        cartViewModel.deleteCart(product)
        Toast.makeText(context,"Removed From Bag", Toast.LENGTH_SHORT).show()
    }

    override fun onItemUpdateClick(product: ProductEntity) {
        cartViewModel.updateCart(product)
    }
}