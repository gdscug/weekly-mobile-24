package com.gdscug.jetpedia.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.ui.theme.JetPediaTheme


@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product,
    onClick: (Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.extraSmall,
        modifier = modifier
            .width(182.dp)
            .height(260.dp)
            .clickable {
                onClick(product.id)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageResourceId),
                contentDescription = product.name + stringResource(R.string.image),
                modifier = Modifier.size(150.dp)
            )
            Column {
                Text(
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 2,
                    text = product.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    text = product.price,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFE3A30)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductPreview() {
    JetPediaTheme {
        ProductCard(product = DummyProductsObject.listOfProduct[0], onClick = {})
    }
}