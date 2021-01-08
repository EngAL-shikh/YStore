package com.amroz.ystore.GsonData

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amroz.ystore.Api.StoreApi
import com.amroz.ystore.Models.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductFetcher {

    private val storeApi: StoreApi = TODO()

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        storeApi = retrofit.create(StoreApi::class.java)
    }

    fun fetchProduct(): MutableLiveData<List<Products>> {
        val responseLiveData: MutableLiveData<List<Products>> = MutableLiveData()
        val proRequest: Call<ProductResponse> = storeApi.fetchProduct()

        proRequest.enqueue(object : Callback<ProductResponse> {
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e("fetchcat", "Failed to fetch ", t)
            }

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                TODO("Not yet implemented")
            }

        })
        return responseLiveData

    }





    fun fetchProductid(id:Int): LiveData<Products> {
        val responseLiveData: MutableLiveData<Products> = MutableLiveData()
        val proRequest: Call<ProductResponse> = storeApi.fetchDetailsProduct(id)

       proRequest.enqueue(object : Callback<ProductResponse> {


           override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
               Log.e("fetchDetailsNews", "Failed to fetch  news Details",t)
           }

           override fun onResponse(
               call: Call<ProductResponse>,
               response: Response<ProductResponse>
           ) {
               TODO("Not yet implemented")
           }
       })

        return responseLiveData
    }

fun fetchDetailsProduct(id:Int): LiveData<Products> {
    val responseLiveData: MutableLiveData<Products> = MutableLiveData()
    val detailsProductRequest: Call<ProductResponse> = storeApi.fetchDetailsProduct(id)

    detailsProductRequest.enqueue(object : Callback<ProductResponse> {



        override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            Log.e("fetchDetailsNews", "Failed to fetch  news Details",t)
        }

        override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
            TODO("Not yet implemented")
        }
    })

    return responseLiveData
}
}




