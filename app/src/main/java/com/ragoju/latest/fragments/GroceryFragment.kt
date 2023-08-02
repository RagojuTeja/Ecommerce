package com.ragoju.latest.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ragoju.latest.R
import com.ragoju.latest.adapters.HomeSliderAdapter
import com.ragoju.latest.adapters.NewProductAdapter
import com.ragoju.latest.data.model.GroceryCategorieData
import com.ragoju.latest.data.model.GroceryCategoryAdapter
import com.ragoju.latest.data.model.NewProductData
import com.ragoju.latest.databinding.FragmentGroceryBinding
import com.ragoju.latest.utils.RvData
import java.util.*


class GroceryFragment : Fragment() {

    private lateinit var binding : FragmentGroceryBinding

    lateinit var rvData : RvData

    lateinit var viewPager: ViewPager
    lateinit var sliderDotspanel: LinearLayout
    lateinit var timer: Timer
    var page_position = 0
    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>
    //    private val categoryList: List<GroceryCategory> = ArrayList<GroceryCategory>()
    private lateinit var groceryCategory_RV: RecyclerView
    lateinit var nRecyclerView: RecyclerView
    private lateinit var pRecyclerView: RecyclerView
    private lateinit var mAdapter: GroceryCategoryAdapter
    private lateinit var nAdapter: NewProductAdapter
//    private lateinit var pAdapter: PopularProductAdapter

    private lateinit var categorieList : ArrayList<GroceryCategorieData>
    private lateinit var newProductList : ArrayList<NewProductData>
    private var images = arrayOf<Int>(
        R.drawable.slider1,
        R.drawable.slider2,
        R.drawable.slider3,
        R.drawable.slider4,
        R.drawable.slider5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentGroceryBinding.inflate(layoutInflater)

        rvData = RvData()

        groceryCategory_RV = binding.categoryRv
        pRecyclerView = binding.popularProductRv
        nRecyclerView = binding.newProductRv

        newproductList()
        categorieDataList()
        popularProductData()


        categorieList = ArrayList()

        (requireActivity().findViewById<View>(com.ragoju.latest.R.id.bottom_nav) as BottomNavigationView).selectedItemId =
            com.ragoju.latest.R.id.nav_graph







//        mAdapter = GroceryCategoryAdapter(data.getCategoryList(), requireContext(), "Home")
//        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView.layoutManager = mLayoutManager
//        recyclerView.itemAnimator = DefaultItemAnimator()
//        recyclerView.adapter = mAdapter
////
////        nAdapter = NewProductAdapter(data.getNewList(), requireContext(), "Home")
//        val nLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        nRecyclerView.layoutManager = nLayoutManager
//        newproductList()
//        nRecyclerView.itemAnimator = DefaultItemAnimator()
//        nRecyclerView.adapter = nAdapter
//
//        pAdapter = PopularProductAdapter(data.getPopularList(), requireContext(), "Home")
//        val pLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        pRecyclerView.layoutManager = pLayoutManager
//        pRecyclerView.itemAnimator = DefaultItemAnimator()
//        pRecyclerView.adapter = pAdapter


        timer = Timer()
        viewPager = binding.viewPager

        sliderDotspanel = binding.SliderDots

        val viewPagerAdapter = HomeSliderAdapter(context, images)

        viewPager.setAdapter(viewPagerAdapter)

        dotscount = viewPagerAdapter.getCount()
        dots = arrayOfNulls(dotscount)

        for (i in 0 until dotscount) {
            dots[i] = ImageView(context)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel.addView(dots[i], params)
        }

        dots[0]!!.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.active_dot))

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]!!.setImageDrawable(
                        ContextCompat.getDrawable(
                            context!!,
                            R.drawable.non_active_dot
                        )
                    )
                }
                dots[position]!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.active_dot
                    )
                )
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        scheduleSlider()

        return binding.root
    }


    private fun newproductList(){

        nAdapter = NewProductAdapter(rvData.newproductList() as ArrayList<NewProductData>)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        nRecyclerView.setLayoutManager(mLayoutManager)
        nRecyclerView.setItemAnimator(DefaultItemAnimator())
        nRecyclerView.setAdapter(nAdapter)

        //        nAdapter.onItemClick = {
//
//            val intent = Intent(activity, ProductViewActivity::class.java)
//            intent.putExtra("product", it)
//            startActivity(intent)
//        }



    }

    private fun categorieDataList(){
        mAdapter = GroceryCategoryAdapter(rvData.grocerycategorieDataList() as ArrayList<GroceryCategorieData>)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        groceryCategory_RV.setLayoutManager(mLayoutManager)
        groceryCategory_RV.setItemAnimator(DefaultItemAnimator())
        groceryCategory_RV.setAdapter(mAdapter)

        //        mAdapter.onItemClick = {
//
//            val intent = Intent(activity, ProductActivity::class.java)
//            startActivity(intent)
//
//        }
    }

    private fun popularProductData(){

         nAdapter = NewProductAdapter(rvData.popularProductData() as ArrayList<NewProductData>)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        pRecyclerView.setLayoutManager(mLayoutManager)
        pRecyclerView.setItemAnimator(DefaultItemAnimator())
        pRecyclerView.setAdapter(nAdapter)

        //        nAdapter.onItemClick = {
//
//            val intent = Intent(activity, ProductViewActivity::class.java)
//            intent.putExtra("product", it)
//            startActivity(intent)
//        }


    }


    fun scheduleSlider() {
        val handler = Handler()
        val update = Runnable {
            page_position = if (page_position == dotscount) {
                0
            } else {
                page_position + 1
            }
            viewPager.setCurrentItem(page_position, true)
        }
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 500, 4000)
    }

    override fun onStop() {
        timer.cancel()
        super.onStop()
    }

    override fun onPause() {
        timer.cancel()
        super.onPause()
    }

//    fun onLetsClicked(view: View?) {
//        startActivity(Intent(context, MainActivity::class.java))
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(requireView(), savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        requireActivity().title = "Home"
    }
}