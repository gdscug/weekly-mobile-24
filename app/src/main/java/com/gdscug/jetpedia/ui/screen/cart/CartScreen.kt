package com.gdscug.jetpedia.ui.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.ui.component.ButtonWithText
import com.gdscug.jetpedia.ui.screen.cart.component.ProductCardHorizontal
import com.gdscug.jetpedia.ui.theme.JetPediaTheme
import com.gdscug.jetpedia.utils.calculateTotalPrice
import com.gdscug.jetpedia.utils.formatAsCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    cartProducts: List<Product>,
    onBackPressed: () -> Unit,
    onCheckoutClick: (List<Product>) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier,
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_small_left),
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                title = {

                },
                actions = {
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = stringResource(R.string.cart),
                        color = Color(0xFF3669C9)
                    )
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, false),
                contentPadding = PaddingValues(bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(items = cartProducts) { product ->
                    ProductCardHorizontal(product = product)
                }
            }
            CartBottom(cartProducts = cartProducts) {

            }
        }

    }
}

@Composable
fun CartBottom(
    modifier: Modifier = Modifier,
    cartProducts: List<Product>, onCheckoutClick: (List<Product>) -> Unit,
) {
    val totalPrices = cartProducts.calculateTotalPrice()
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        Text(
            modifier = Modifier.align(Alignment.End),
            text = "Total : Rp. ${totalPrices.formatAsCurrency()}",
            style = MaterialTheme.typography.headlineLarge
        )
        ButtonWithText(onClick = { onCheckoutClick(cartProducts) }, text = "Checkout")
    }
}


@Preview
@Composable
private fun CartScreenPreview() {
    JetPediaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CartScreen(
                modifier = Modifier,
                cartProducts = DummyProductsObject.listOfProduct.take(3),
                onCheckoutClick = {},
                onBackPressed = {}
            )
        }
    }
}

