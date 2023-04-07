package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.adapter.ProductAdapter
import com.example.myapp.models.Product

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val rvProds = findViewById<RecyclerView>(R.id.rvProducts)
        rvProds.adapter = ProductAdapter(getProducts())
    }

    private fun getProducts():MutableList<Product>{
        val products = mutableListOf<Product>()
        products.add(Product("101","Samsung A53","Mobile Phone",67000.00))
        products.add(Product("102","Samsung A54","Mobile Phone",77000.00))
        products.add(Product("103","Samsung A55","Mobile Phone",87000.00))
        products.add(Product("104","Samsung A56","Mobile Phone",57000.00))
        products.add(Product("105","Samsung A57","Mobile Phone",47000.00))
        products.add(Product("106","Samsung A58","Mobile Phone",97000.00))
        products.add(Product("107","Samsung A59","Mobile Phone",107000.00))
        return products
    }


}