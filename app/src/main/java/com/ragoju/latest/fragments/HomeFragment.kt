package com.ragoju.latest.fragments


import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ragoju.latest.R
import com.ragoju.latest.activities.ProductDetailsActivity
import com.ragoju.latest.adapters.*
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.FragmentHomeBinding
import com.ragoju.latest.utils.RvData


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

//    private lateinit var rvData: RvData

    private lateinit var viewFlipper    : android.widget.ViewFlipper
    private lateinit var recyclerViewCG : RecyclerView
    private lateinit var dealsRV        : RecyclerView
    private lateinit var trndRV         : RecyclerView
    private lateinit var bestRV         : RecyclerView
    private lateinit var topDealRV      : RecyclerView
    lateinit var rvData : RvData

    lateinit var homeCategoryAdapter    : HomeCategoryAdapter
    lateinit var productAdapter        : ProductAdapter
    lateinit var trendingAdapter       : TrendingAdapter
    lateinit var topDealsAdapter        : TopDealsAdapter


    private var imageList = intArrayOf(
        R.drawable.viewflipper2,
        R.drawable.viewflipper,
        R.drawable.viewflipper,
        R.drawable.viewflipper2,
        R.drawable.viewflipper,
        R.drawable.viewflipper2
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)



        viewFlipper    = binding.viewFlipper
        recyclerViewCG = binding.homeCgRecycler
        dealsRV        = binding.homeDealsRV
        trndRV         = binding.homeTrendOffRV
        bestRV         = binding.homeBestsellerRV
        topDealRV      = binding.homeTopdealRV
        rvData         = RvData()



        viewFliper()
        homeCategory()
        homeDeals()
        homeTrendingOffer()
        homeBestOff()
        homeTopDeals()

//        rvData = RvData(context as Activity)

        binding.searchviewBox.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }



        return binding.root
    }

    fun viewFliper(){

        viewFlipper.setInAnimation(context, android.R.anim.slide_out_right)
        viewFlipper.setOutAnimation(context, android.R.anim.slide_in_left)

        // Add imageView for each image to viewFlipper.
        for (image in imageList) {
            val imageView = ImageView(context)
            val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            layoutParams.setMargins(10, 10, 10, 10)
            layoutParams.gravity = Gravity.FILL_HORIZONTAL
            imageView.layoutParams = layoutParams
            imageView.setImageResource(image)
            viewFlipper.addView(imageView)
        }

    }

    fun homeCategory() {

        homeCategoryAdapter = HomeCategoryAdapter(rvData.getCategoryList() as ArrayList<HomeData>)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCG.setLayoutManager(mLayoutManager)
        recyclerViewCG.setItemAnimator(DefaultItemAnimator())
        recyclerViewCG.setAdapter(homeCategoryAdapter)

//        Log.e(ContentValues.TAG, "offerProduct: $categoryList")
    }

    fun homeDeals() {

        dealsAdapter = DealsAdapter(rvData.getDealsList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        dealsRV.setLayoutManager(mLayoutManager)
        dealsRV.setItemAnimator(DefaultItemAnimator())
        dealsRV.setAdapter(dealsAdapter)

        val groceryFragment = GroceryFragment()

        dealsAdapter.onItemClick = {

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(com.ragoju.latest.R.id.frame_bottom, groceryFragment)?.addToBackStack(null)?.commit()


        }
    }

    fun homeTrendingOffer() {

        trendingAdapter = TrendingAdapter(rvData.getTrendList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        trndRV.setLayoutManager(mLayoutManager)
        trndRV.setItemAnimator(DefaultItemAnimator())
        trndRV.setAdapter(trendingAdapter)

       trendingAdapter.onItemClick = {

            val intent = Intent(activity, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)

        }
    }

    fun homeBestOff() {

        productAdapter = ProductAdapter(rvData.getBestList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bestRV.setLayoutManager(mLayoutManager)
        bestRV.setItemAnimator(DefaultItemAnimator())
        bestRV.setAdapter(productAdapter)

        productAdapter.onItemClick = {

            val intent = Intent(activity, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }

    fun homeTopDeals() {

        topDealsAdapter= TopDealsAdapter(rvData.getTopDealList() as ArrayList<HomeData>, requireContext())
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        topDealRV.setLayoutManager(mLayoutManager)
        topDealRV.setItemAnimator(DefaultItemAnimator())
        topDealRV.setAdapter(topDealsAdapter)

       topDealsAdapter.onItemClick = {

            val intent = Intent(activity, ProductDetailsActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        lateinit var dealsAdapter           : DealsAdapter

    }
}
