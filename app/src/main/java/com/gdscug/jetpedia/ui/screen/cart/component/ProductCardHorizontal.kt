package com.gdscug.jetpedia.ui.screen.cart.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.gdscug.jetpedia.data.local.DummyProductsObject
import com.gdscug.jetpedia.data.local.model.Product
import com.gdscug.jetpedia.ui.theme.JetPediaTheme

@Composable
fun ProductCardHorizontal(
    modifier: Modifier = Modifier,
    product: Product,

) {
    Card(
        shape = MaterialTheme.shapes.extraSmall,
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment  = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageResourceId),
                contentDescription = product.name + stringResource(R.string.image),
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier.align(Alignment.Top)
            ) {
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
private fun ProductCardHorizontalPreview() {
    JetPediaTheme {
        ProductCardHorizontal(product = DummyProductsObject.listOfProduct[0])
    }
}