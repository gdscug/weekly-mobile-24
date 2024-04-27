package com.gdscug.jetpedia.ui.screen.detail

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.ui.component.ButtonWithText
import com.gdscug.jetpedia.ui.theme.JetPediaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    product: Product,
    onAddToCartClick: (Int) -> Unit,
    onBackPressed: () -> Unit,
) {

    Scaffold(
        modifier = modifier, topBar = {
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
                        text = stringResource(R.string.detail),
                        color = Color(0xFF3669C9)
                    )
                },

                )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {

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
                    .weight(1f, false),
                contentPadding = PaddingValues(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    Image(
                        modifier = Modifier.size(325.dp),
                        painter = painterResource(id = product.imageResourceId),
                        contentDescription = "Product Image"
                    )
                }
                item {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = product.name, style = MaterialTheme.typography.headlineLarge)
                        Text(
                            style = MaterialTheme.typography.bodyLarge,
                            text = product.price,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFFE3A30)
                        )
                    }
                }

                item {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Description Product",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            style = MaterialTheme.typography.bodyLarge.copy(
                                textAlign = TextAlign.Justify,
                            ),
                            text = product.description
                        )

                    }

                }
            }
            ButtonWithText(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = {
                    onAddToCartClick(product.id)
                },
                text = stringResource(R.string.add_to_cart)
            )
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DetailScreenPreview() {
    JetPediaTheme {
        Surface(

            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,  // Adapts to theme
        ) {
            DetailScreen(
                modifier = Modifier,
                product = DummyProductsObject.listOfProduct[2],
                onAddToCartClick = {},
                onBackPressed = {}
            )
        }

    }
}
