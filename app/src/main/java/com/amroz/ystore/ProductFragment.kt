package com.amroz.ystore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amroz.ystore.model.Product


class ProductFragment : Fragment() {
    private lateinit var productRecyclerView: RecyclerView
    private var adapter: ProductFragment.ProductAdapter? = null
    lateinit var product_name: TextView
    lateinit var product_image: ImageButton
    lateinit var product_price: TextView
    lateinit var product_rate: ImageButton
    private val storeListViewModel: StoreListViewModel by lazy {
        ViewModelProviders.of(this).get(StoreListViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)
        productRecyclerView =view.findViewById(R.id.product_recycler_view) as RecyclerView
        productRecyclerView.layoutManager = LinearLayoutManager(context)

        productRecyclerView.adapter = adapter

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*  productListViewModel.productList.observe(
           viewLifecycleOwner,
             Observer { products ->
                 products?.let {
                      updateUI(products)
                  }
              })
  */

    }
    private fun updateUI(product: List<Product>) {

        adapter = ProductAdapter(product)
        productRecyclerView.adapter = adapter

    }
    private inner class ProductHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {
        val product_nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val product_rateimageButton: ImageButton = itemView.findViewById(R.id.product_rate)
        val product_imageButton: ImageButton = itemView.findViewById(R.id.product_image)
        val product_priceButton: TextView = itemView.findViewById(R.id.product_price)


        private lateinit var product: Product

        init {
            product_imageButton.setOnClickListener(this)

        }

        fun bind( product: Product) {
            this.product = product
            product_nameTextView.text = this.product.name
            product_priceButton.text=this.product.price.toString()
            //  imageTextView.setImageBitmap(this.product.image)

        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
    private inner class ProductAdapter(var products: List<Product>) :
        RecyclerView.Adapter<ProductHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
            val view = layoutInflater.inflate(R.layout.product_list, parent, false)
            return ProductHolder(view)
        }

        override fun getItemCount(): Int {
            return products.size
        }

        override fun onBindViewHolder(holder: ProductHolder, position: Int) {
            val product = products[position]
            holder.bind(product )
        }


    }

    companion object {

        fun newInstance() = ProductFragment()

    }
}