package com.gdscug.jetpedia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gdscug.jetpedia.R

val DMSans = FontFamily(
    Font(R.font.dm_sans_regular, FontWeight.Normal),
    Font(R.font.dm_sans_semibold, FontWeight.SemiBold),
    Font(R.font.dm_sans_medium, FontWeight.Medium),
    Font(R.font.dm_sans_bold, FontWeight.Bold),

    )


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    bodyMedium = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    bodySmall = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),

    displayLarge = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    displayMedium = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    displaySmall = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    headlineMedium = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    headlineSmall = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    titleLarge = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    titleMedium = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    titleSmall = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    labelLarge = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    labelMedium = TextStyle.Default.copy(
        fontFamily = DMSans,
    ),
    labelSmall = TextStyle.Default.copy(
        fontFamily = DMSans,
    )


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */

)