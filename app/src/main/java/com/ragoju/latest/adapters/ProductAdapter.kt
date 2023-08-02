package com.ragoju.latest.adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.activities.ProductDetailsActivity
import com.ragoju.latest.data.model.HomeData

class ProductAdapter(private val productList: ArrayList<HomeData>, context: Context): RecyclerView.Adapter<ProductAdapter.ViewHolder>()  {

    val ctx: Context = context

    var onItemClick : ((HomeData)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val productView = LayoutInflater.from(parent.context).inflate(R.layout.single_product,parent,false)
        return ViewHolder(productView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product: HomeData = productList[position]
        holder.productBrandName_singleProduct.text = product.Name2
        holder.productName_singleProduct.text = product.Name
        holder.productPrice_singleProduct.text = "$"+product.Price
        holder.productRating_singleProduct.rating = product.rating

        Glide.with(ctx)
            .load(product.Image)
            .placeholder(R.drawable.bn)
            .into(holder.productImage_singleProduct)


        if(product.productHave == true){
            holder.discountTv_singleProduct.text = product.Discount
            holder.discount_singleProduct.visibility = View.VISIBLE
        }

        if(product.productHave == false){

            holder.discount_singleProduct.visibility = View.VISIBLE
            holder.discountTv_singleProduct.text = "New"

        }


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(product)
        }

    }

    override fun getItemCount(): Int {
         return productList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val productImage_singleProduct:ImageView = itemView.findViewById(R.id.productImage_singleProduct)
        val productAddToFav_singleProduct:ImageView = itemView.findViewById(R.id.productAddToFav_singleProduct)
        val productRating_singleProduct:RatingBar = itemView.findViewById(R.id.productRating_singleProduct)
        val productBrandName_singleProduct:TextView = itemView.findViewById(R.id.productBrandName_singleProduct)
        val discountTv_singleProduct:TextView = itemView.findViewById(R.id.discountTv_singleProduct)
        val productName_singleProduct:TextView = itemView.findViewById(R.id.productName_singleProduct)
        val productPrice_singleProduct:TextView = itemView.findViewById(R.id.productPrice_singleProduct)
        val discount_singleProduct = itemView.findViewById<LinearLayout>(R.id.discount_singleProduct)


    }

    private fun goDetailsPage(position: Int) {
        val intent = Intent(ctx , ProductDetailsActivity::class.java)
        intent.putExtra("ProductIndex", position)
        intent.putExtra("ProductFrom", "New")
        ctx.startActivity(intent)
    }
}