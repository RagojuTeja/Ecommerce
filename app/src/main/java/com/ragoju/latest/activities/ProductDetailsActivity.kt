package com.ragoju.latest.activities

import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.buynow.data.local.room.CartViewModel
import com.ragoju.latest.R
import com.ragoju.latest.adapters.ProductAdapter
import com.ragoju.latest.data.ProductEntity
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.databinding.ActivityProductDetailsBinding
import com.ragoju.latest.utils.Extensions.toast
import com.ragoju.latest.utils.RvData

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProductDetailsBinding

    private val TAG = "TAG"
    lateinit var productImage_ProductDetailsPage: ImageView
    lateinit var backIv_ProfileFrag: ImageView
    lateinit var productName_ProductDetailsPage: TextView
    lateinit var productPrice_ProductDetailsPage: TextView
    lateinit var productBrand_ProductDetailsPage: TextView
    lateinit var productDes_ProductDetailsPage: TextView
    lateinit var RatingProductDetails: TextView
    lateinit var productRating_singleProduct: RatingBar
    lateinit var addToCart_ProductDetailsPage : Button

    private lateinit var cartViewModel: CartViewModel

    lateinit var rvData : RvData


    lateinit var RecomRecView_ProductDetailsPage: RecyclerView
    lateinit var newProductAdapter: ProductAdapter

    var qua: Int = 1
    var pPrice: Int = 0

    lateinit var pName: String
    lateinit var pPid: String
    var pImage : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvData         = RvData()

        window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        productImage_ProductDetailsPage = binding.productImageProductDetailsPage
        productName_ProductDetailsPage = binding.productNameProductDetailsPage
        productPrice_ProductDetailsPage = binding.productPriceProductDetailsPage
        productBrand_ProductDetailsPage = binding.productBrandProductDetailsPage
        productDes_ProductDetailsPage = binding.productDesProductDetailsPage
        productRating_singleProduct = binding.productRatingSingleProduct
        RatingProductDetails = binding.RatingProductDetails
        RecomRecView_ProductDetailsPage = binding.RecomRecViewProductDetailsPage
        backIv_ProfileFrag = binding.backIvProfileFrag
        addToCart_ProductDetailsPage = binding.addToCartProductDetailsPage

//        val categoryList = RvData.getrvdata.getBestList()
//        RecomRecView_ProductDetailsPage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        RecomRecView_ProductDetailsPage.setHasFixedSize(true)
//        newProductAdapter = ProductAdapter(categoryList as ArrayList<HomeData>, this)
//        RecomRecView_ProductDetailsPage.adapter = newProductAdapter

        newProductAdapter = ProductAdapter(rvData.getBestList() as ArrayList<HomeData>,this)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        RecomRecView_ProductDetailsPage.setLayoutManager(mLayoutManager)
        RecomRecView_ProductDetailsPage.setItemAnimator(DefaultItemAnimator())
        RecomRecView_ProductDetailsPage.setAdapter(newProductAdapter)

        backIv_ProfileFrag.setOnClickListener {
            onBackPressed()
        }

        val product = intent.getParcelableExtra<HomeData>("product")

        if (product != null) {

//            Glide.with(applicationContext)
//                .load(product.Image)
//                .error(R.drawable.fashion_2)
//                .placeholder(R.drawable.fashion_2)
//                .into(productImage_ProductDetailsPage)

            productName_ProductDetailsPage.text = product. Name
            productPrice_ProductDetailsPage.text = "$" + product.Price
            productBrand_ProductDetailsPage.text = product.Name2
            RatingProductDetails.text = product.rating.toString()
            productImage_ProductDetailsPage.setImageResource(product.Image)


            pName = product.Name
            pPrice = product.Price.toInt()
            pPid = product.Discount
            pImage = product.Image

        }

        addToCart_ProductDetailsPage.setOnClickListener { addProductToBag() }
    }

    private fun addProductToBag() {

        cartViewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)
        cartViewModel.insert(ProductEntity(pName, qua, pPrice, pPid, pImage.toString()))
        toast("Add to Bag Successfully")
    }
}





//
//
//addToCart_ProductDetailsPage.setOnClickListener {
//
////            val bottomSheetDialod = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
////
////            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(R.layout.fragment_add_to_bag,
////                findViewById<ConstraintLayout>(R.id.bottomSheet)
////            )
////
////            bottomSheetView.findViewById<View>(R.id.addToCart_BottomSheet).setOnClickListener {
////
////                pPrice *= bottomSheetView.findViewById<EditText>(R.id.quantityEtBottom).text.toString()
////                    .toInt()
//    addProductToBag()
////                bottomSheetDialod.dismiss()
////            }
//
////            bottomSheetView.findViewById<LinearLayout>(R.id.minusLayout).setOnClickListener {
////                if(bottomSheetView.findViewById<EditText>(R.id.quantityEtBottom).text.toString()
////                        .toInt() > 1){
////                    qua--
////                    bottomSheetView.findViewById<EditText>(R.id.quantityEtBottom).setText(qua.toString())
////                }
////            }
////
////            bottomSheetView.findViewById<LinearLayout>(R.id.plusLayout).setOnClickListener {
////                if(bottomSheetView.findViewById<EditText>(R.id.quantityEtBottom).text.toString()
////                        .toInt() < 10){
////                    qua++
////                    bottomSheetView.findViewById<EditText>(R.id.quantityEtBottom).setText(qua.toString())
////                }
////            }
////
////            bottomSheetDialod.setContentView(bottomSheetView)
////            bottomSheetDialod.show()
//}
//}


