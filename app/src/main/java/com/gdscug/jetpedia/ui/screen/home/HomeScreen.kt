package com.gdscug.jetpedia.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.CategoriesObject
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.ui.screen.home.component.Categories
import com.gdscug.jetpedia.data.local.model.ProductCategory
import com.gdscug.jetpedia.ui.screen.home.component.ProductDisplay
import com.gdscug.jetpedia.ui.theme.JetPediaTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onProductClick: (Int) -> Unit,
    onCartClicked: () -> Unit,
    products: List<Product>,
) {
    Scaffold(modifier = modifier, topBar = {
        TopAppBar(
            modifier = Modifier,
            title = {
                Text(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(R.string.app_name),
                    color = Color(0xFF3669C9)
                )
            },
            actions = {
                IconButton(onClick = onCartClicked) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cart),
                        contentDescription = "Cart"
                    )
                }
            },
        )
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            item {
                var searchQuery by remember { mutableStateOf("") }
                var searchActiveState by remember {
                    mutableStateOf(true)
                }
                SearchBar(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    colors = SearchBarDefaults.colors(),
                    query = searchQuery,
                    onQueryChange = {
                        searchQuery = it
                    },
                    onSearch = {
                        if (searchQuery.isNotBlank()) {
                            searchActiveState = !searchActiveState
                        }
                    },
                    onActiveChange = { searchActiveState = it },
                    active = false,
                    placeholder = {
                        Text(modifier = Modifier.semantics {
                            invisibleToUser()
                        }, text = stringResource(R.string.search_placeholder))
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    },
                ) {
                }

            }
            item { CategoriesDisplay() }
            item {
                ProductDisplay(
                    products = products.filter { product -> product.isFeatured },
                    title = stringResource(R.string.featured_product),
                    onProductClick = onProductClick
                )
            }
            val displayedProductCategory: List<ProductCategory> = listOf(
                ProductCategory.ELECTRONICS,
                ProductCategory.PHONES,
                ProductCategory.WEARABLES
            )
            items(displayedProductCategory) { categoryItem ->
                ProductDisplay(
                    title = categoryItem.string,
                    products = products.filter { it.category == categoryItem },
                    onProductClick = onProductClick
                )
            }
        }

    }
}

@Composable
private fun CategoriesDisplay() {
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Categories",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Categories(categoryList = CategoriesObject.listOfCategory)
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreview() {
    JetPediaTheme {
        Surface(

            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,  // Adapts to theme
        ) {
            HomeScreen(
                modifier = Modifier,
                onProductClick = {},
                onCartClicked = {},
                products = DummyProductsObject.listOfProduct
            )
        }

    }
}