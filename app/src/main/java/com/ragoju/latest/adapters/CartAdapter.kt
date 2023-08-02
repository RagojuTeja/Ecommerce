package com.ragoju.latest.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ragoju.latest.R
import com.ragoju.latest.data.ProductEntity

class CartAdapter(private val ctx: Context, val listener: CartItemClickAdapter):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val cartList: ArrayList<ProductEntity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val cartView = LayoutInflater.from(ctx).inflate(R.layout.cart_item_view,parent,false)

        return CartViewHolder(cartView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {


        val cartItem: ProductEntity = cartList[position]

        Glide.with(ctx)
            .load(cartItem.Image)
            .into(holder.cartImage)

        holder.cartName.text = cartItem.name
        holder.cartPrice.text = "$"+ cartItem.price
        holder.quantityTvCart.text = cartItem.qua.toString()



        holder.cartMore.setOnClickListener {
            listener.onItemDeleteClick(cartItem)
        }
    }





    override fun getItemCount(): Int {
        return cartList.size
    }



    class CartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val cartImage: ImageView = itemView.findViewById(R.id.cartImage)
        val cartMore: ImageView = itemView.findViewById(R.id.cartDelete)
        val cartName: TextView = itemView.findViewById(R.id.cartName)
        val cartPrice: TextView = itemView.findViewById(R.id.cartPrice)
        val quantityTvCart: TextView = itemView.findViewById(R.id.quantityTv)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<ProductEntity>){
        cartList.clear()
        cartList.addAll(newList)
        notifyDataSetChanged()
    }


}

interface CartItemClickAdapter{
    fun onItemDeleteClick(product: ProductEntity)
    fun onItemUpdateClick(product: ProductEntity)
}