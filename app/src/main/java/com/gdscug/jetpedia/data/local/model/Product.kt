package com.gdscug.jetpedia.data.local.model

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val isFeatured: Boolean,
    @DrawableRes val imageResourceId: Int,
    val category: ProductCategory,
    val description: String
)