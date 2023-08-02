package com.ragoju.latest.utils

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ViewFlipper
import com.ragoju.latest.R

class ViewFlipper( activity: Activity){

//private  var viewFlipper: ViewFlipper? = null

    var viewFlipper = activity.findViewById<ViewFlipper>(R.id.viewFlipper)



    private var imageList = intArrayOf(
        R.drawable.viewflipper2,
        R.drawable.viewflipper,
        R.drawable.viewflipper,
        R.drawable.viewflipper2,
        R.drawable.viewflipper,
        R.drawable.viewflipper2
    )

    fun fzsdvv(context: Context) {

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
}