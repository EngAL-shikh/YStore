package com.amroz.ystore.model

import org.w3c.dom.Text

data class Product(
     var name: String,
 var image:List<String>,
     var details:Text,
     var price:Double,
     var rate:Int
 ) {
}