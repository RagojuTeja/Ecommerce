package com.ragoju.latest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ragoju.latest.R

/**
 * Grocery App
 * https://github.com/quintuslabs/GroceryStore
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
class HomeSliderAdapter : PagerAdapter {
    private var context: Context
    private var layoutInflater: LayoutInflater? = null
    private lateinit var images: Array<Int>

    constructor(context: Context) {
        this.context = context
    }

    constructor(context: Context?, images: Array<Int>) {
        this.context = context!!
        this.images = images
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater!!.inflate(R.layout.item_home_slider, null)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(images[position])
        val vp: ViewPager = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp: ViewPager = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}