package com.gdscug.jetpedia.ui.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.ui.theme.JetPediaTheme


@Composable
fun ProductDisplay(
    modifier: Modifier = Modifier,
    title: String,
    products: List<Product>,
    onProductClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 16.dp),
            text = title
        )
        ProductsRow(listOfProduct = products, onClick = onProductClick )
    }
}

@Composable
fun ProductsRow(
    modifier: Modifier = Modifier,
    listOfProduct: List<Product>,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = modifier.padding(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (listOfProduct.size < 2) {
            ProductCard(modifier = modifier, product = listOfProduct[0], onClick = onClick)
        } else {
            listOfProduct.take(2).forEach { productItem ->
                ProductCard(
                    modifier = modifier.weight(1f),
                    product = productItem,
                    onClick = onClick
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDisplayPreview() {
    JetPediaTheme {
        ProductDisplay(
            title = stringResource(R.string.featured_product),
            products = DummyProductsObject.listOfProduct,
            onProductClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SingleProductDisplayPreview() {
    JetPediaTheme {
        ProductDisplay(
            title = stringResource(R.string.featured_product),
            products = DummyProductsObject.listOfProduct.take(1),
            onProductClick = {}
        )
    }
}