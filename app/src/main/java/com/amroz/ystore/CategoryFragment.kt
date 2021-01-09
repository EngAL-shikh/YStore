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
import com.amroz.ystore.Models.Category


class CategoryFragment : Fragment() {
    private lateinit var categoryRecyclerView: RecyclerView
    private var adapter: CategoryAdapter? = null
    lateinit var category_name: TextView
    lateinit var category_Image: ImageButton
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

        val view = inflater.inflate(R.layout.fragment_category, container, false)
        categoryRecyclerView =view.findViewById(R.id.category_recycler_view) as RecyclerView
        categoryRecyclerView.layoutManager = LinearLayoutManager(context)

        categoryRecyclerView.adapter = adapter

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      /*  storeListViewModell.categoryList.observe(
         viewLifecycleOwner,
           Observer { categories ->
               categories?.let {
                    updateUI(categories)
                }
            })
*/

    }
    private fun updateUI(category: List<Category>) {

        adapter = CategoryAdapter(category)
        categoryRecyclerView.adapter = adapter

    }
    private inner class CategoryHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {
        val nameTextView: TextView = itemView.findViewById(R.id.category_name)
        val imageTextView: ImageButton = itemView.findViewById(R.id.category_image)


        private lateinit var category: Category

        init {
            imageTextView.setOnClickListener(this)
        }

        fun bind(category: Category) {
            this.category = category
            nameTextView.text = this.category.name
          //  imageTextView.setImageBitmap(this.category.image)

        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
    private inner class CategoryAdapter(var categories: List<Category>) :
        RecyclerView.Adapter<CategoryHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
            val view = layoutInflater.inflate(R.layout.category_list, parent, false)
            return CategoryHolder(view)
        }

        override fun getItemCount(): Int {
           return categories.size
        }

        override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
            val category = categories[position]
            holder.bind(category )
        }


    }
    companion object {

        fun newInstance() = CategoryFragment()


            }


    }
