package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.models.Product

class ProductAdapter(var productList: MutableList<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivProduct = view.findViewById<ImageView>(R.id.ivProduct)
        val txName = view.findViewById<TextView>(R.id.txName)
        val txCategory = view.findViewById<TextView>(R.id.txCategory)
        val txPrice = view.findViewById<TextView>(R.id.txPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.txName.text = product.name
        holder.txCategory.text = product.category
        holder.txPrice.text = "Rs. ${product.price}"
    }
}