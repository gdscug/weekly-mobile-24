package com.gdscug.jetpedia.utils

import com.gdscug.jetpedia.data.local.model.Product
import java.text.DecimalFormat
import java.text.NumberFormat


fun String.convertToDouble(): Int {
    return this
        .replace("Rp ", "")
        .replace(".", "").trim().toInt()
}

fun List<Product>.calculateTotalPrice(): Int {
    return this.sumOf { it.price.convertToDouble() }
}

fun Int.formatAsCurrency(): String {
    val format: NumberFormat = DecimalFormat("#,###")
    return format.format(this)
}