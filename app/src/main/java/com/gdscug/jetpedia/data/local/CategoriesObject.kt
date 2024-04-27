package com.gdscug.jetpedia.data.local

import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.model.CategoryItem
import com.gdscug.jetpedia.data.local.model.ProductCategory

object CategoriesObject {
    val listOfCategory = listOf(
        CategoryItem(iconId = R.drawable.ic_all_product, type = ProductCategory.ALL_PRODUCT),
        CategoryItem(iconId = R.drawable.ic_on_sale, type = ProductCategory.ON_SALE),
        CategoryItem(iconId = R.drawable.ic_electronic, type = ProductCategory.ELECTRONICS),
        CategoryItem(iconId = R.drawable.ic_phone, type = ProductCategory.PHONES),
        CategoryItem(iconId = R.drawable.ic_wearable, type = ProductCategory.WEARABLES)
    )
}