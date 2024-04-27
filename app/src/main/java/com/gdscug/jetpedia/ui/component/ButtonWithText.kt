package com.gdscug.jetpedia.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ButtonWithText(modifier: Modifier = Modifier, onClick: () -> Unit, text: String) {
    Button(
        shape = MaterialTheme.shapes.small,
        onClick = onClick,
        modifier = modifier.fillMaxWidth()

    ) {
        Text(
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            text = text
        )
    }
}