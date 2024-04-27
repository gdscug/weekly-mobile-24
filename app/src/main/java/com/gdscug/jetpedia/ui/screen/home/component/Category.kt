package com.gdscug.jetpedia.ui.screen.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdscug.jetpedia.R
import com.gdscug.jetpedia.ui.theme.JetPediaTheme

@Composable
fun Category(
    modifier: Modifier = Modifier,
    @DrawableRes categoryIconId: Int,
    catergoryType: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Card(modifier = Modifier.padding(horizontal = 14.dp), shape = MaterialTheme.shapes.extraLarge) {
            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = categoryIconId),
                contentDescription = catergoryType
            )
        }
        Text(text = catergoryType, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryPreview() {
    JetPediaTheme {
        Category(
            categoryIconId = R.drawable.ic_all_product,
            catergoryType = "All Product"
        )
    }
}

