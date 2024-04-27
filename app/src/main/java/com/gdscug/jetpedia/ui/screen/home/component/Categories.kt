package com.gdscug.jetpedia.ui.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdscug.jetpedia.data.local.CategoriesObject
import com.gdscug.jetpedia.data.local.model.CategoryItem
import com.gdscug.jetpedia.ui.theme.JetPediaTheme

@Composable
fun Categories(modifier: Modifier = Modifier, categoryList: List<CategoryItem>) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(categoryList) { categoryItem ->
            Category(
                categoryIconId = categoryItem.iconId,
                catergoryType = categoryItem.type.string
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoriesPreview() {
    JetPediaTheme {
        Categories(categoryList = CategoriesObject.listOfCategory)
    }
}

