package com.ragoju.latest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ragoju.latest.R
import com.ragoju.latest.data.ProductEntity

//class CartAdapters(private val cartClickedListeners: CartClickedListeners) :
//    RecyclerView.Adapter<CartAdapters.CartViewHodler>() {
//    private var productCartList: List<ProductEntity>? = null
//    fun setShoeCartList(shoeCartList: List<ProductEntity>?) {
//        this.productCartList = shoeCartList
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHodler {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_view, parent, false)
//        return CartViewHodler(view)
//    }
//
//    override fun onBindViewHolder(holder: CartViewHodler, position: Int) {
//        val productCart = productCartList!![position]
//        holder.cartImageView.setImageResource(productCart.Product_Image)
//        holder.cartNameTv.text = productCart.Product_Name
//        holder.cartBrandNameTv.text = productCart.shoeBrandName
//        holder.cartQuantity.text = productCart.Product_Quantity.toString() + ""
//        holder.cartPriceTv.text = productCart.totalItemPrice.toString() + ""
//        holder.deletecartBtn.setOnClickListener { cartClickedListeners.onDeleteClicked(productCart) }
//        holder.addQuantityBtn.setOnClickListener { cartClickedListeners.onPlusClicked(productCart) }
//        holder.minusQuantityBtn.setOnClickListener { cartClickedListeners.onMinusClicked(productCart) }
//    }
//
//    override fun getItemCount(): Int {
//        return if (productCartList == null) {
//            0
//        } else {
//            productCartList!!.size
//        }
//    }
//
//    inner class CartViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val cartNameTv: TextView
//        val cartBrandNameTv: TextView
//        val cartPriceTv: TextView
//        val cartQuantity: TextView
//        val deletecartBtn: ImageButton
//        val cartImageView: ImageView
//        val addQuantityBtn: LinearLayout
//        val minusQuantityBtn:LinearLayout
//
//        init {
//            cartNameTv = itemView.findViewById(R.id.cartName)
//            cartBrandNameTv = itemView.findViewById(R.id.cart_brandname)
//            cartPriceTv = itemView.findViewById(R.id.cartPrice)
//            deletecartBtn = itemView.findViewById(R.id.cartDelete)
//            cartImageView = itemView.findViewById(R.id.cartImage)
//            cartQuantity = itemView.findViewById(R.id.quantityTv)
//            addQuantityBtn = itemView.findViewById(R.id.plusLayout_cart)
//            minusQuantityBtn = itemView.findViewById(R.id.minusLayout_cart)
//        }
//    }
//
//    interface CartClickedListeners {
//        fun onDeleteClicked(productEntity: ProductEntity?)
//        fun onPlusClicked(productEntity: ProductEntity)
//        fun onMinusClicked(productEntity: ProductEntity)
//    }
//}