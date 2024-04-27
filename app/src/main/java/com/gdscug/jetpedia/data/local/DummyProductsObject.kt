package com.gdscug.jetpedia.data.local

import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.data.local.model.ProductCategory


object DummyProductsObject {
    val listOfProduct = listOf(
        Product(
            id = 1,
            name = "ROG Ally (2023)",
            price = "Rp 10.549.000",
            imageResourceId = R.drawable.rog_ally_512px,
            isFeatured = true,
            category = ProductCategory.ELECTRONICS,
            description = "The ROG Ally (2023) is a cutting-edge gaming laptop featuring the latest GPU for superior performance in the most demanding games and creative projects."
        ),
        Product(
            id = 2,
            name = "iPhone 14 Pro Max",
            price = "Rp 20.999.000",
            imageResourceId = R.drawable.iphone_14_pro_max,
            isFeatured = false,
            category = ProductCategory.PHONES,
            description = "Apple's iPhone 14 Pro Max boasts enhanced photography capabilities, a more powerful chip, and a durable design, making it a top choice for tech enthusiasts."
        ),
        Product(
            id = 3,
            name = "Fitbit Charge 5",
            price = "Rp 3.299.000",
            imageResourceId = R.drawable.fitbit_charge_5_512px,
            isFeatured = false,
            category = ProductCategory.WEARABLES,
            description = "Optimize your workout routine with the Fitbit Charge 5, featuring advanced fitness tracking, built-in GPS, and a sleek, comfortable design."
        ),
        Product(
            id = 4,
            name = "Samsung Galaxy S22",
            price = "Rp 15.499.000",
            imageResourceId = R.drawable.samsung_galaxy_s22_512px,
            isFeatured = false,
            category = ProductCategory.PHONES,
            description = "The Samsung Galaxy S22 offers a pro-grade camera system, dynamic AMOLED display, and robust processing power, packaged in a sleek design."
        ),
        Product(
            id = 5,
            name = "Galaxy Watch6 Classic (47mm)",
            price = "Rp 3.999.000",
            imageResourceId = R.drawable.galaxy_watch6_classic_512px,
            isFeatured = false,
            category = ProductCategory.WEARABLES,
            description = "The Galaxy Watch6 Classic combines traditional watch aesthetics with modern smartwatch features, including health monitoring and mobile connectivity."
        ),
        Product(
            id = 6,
            name = "Fitbit Charge 5",
            price = "Rp 1.990.000",
            imageResourceId = R.drawable.fitbit_charge_5_512px,
            isFeatured = false,
            category = ProductCategory.WEARABLES,
            description = "The Fitbit Charge 5 offers personalized fitness insights, built-in GPS for real-time pace and distance, making it ideal for fitness enthusiasts."
        ),
        Product(
            id = 7,
            name = "JBL Flip 5",
            price = "Rp 1.800.000",
            imageResourceId = R.drawable.jbl_flip_5_512px,
            isFeatured = false,
            category = ProductCategory.ELECTRONICS,
            description = "Experience powerful audio with the portable JBL Flip 5, featuring a waterproof design and a robust sound profile that’s perfect for outdoor adventures."
        ),
        Product(
            id = 8,
            name = "Steam Deck OLED",
            price = "Rp 13.999.000",
            imageResourceId = R.drawable.steam_deck_oled_512px,
            isFeatured = true,
            category = ProductCategory.ELECTRONICS,
            description = "The Steam Deck OLED model enhances your gaming with vibrant display colors, better battery life, and extensive game library access on-the-go."
        )
    )
}