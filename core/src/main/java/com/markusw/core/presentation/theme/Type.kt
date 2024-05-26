@file:Suppress("SpellCheckingInspection")

package com.markusw.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.markusw.core.R


val kadwa = FontFamily(
    Font(R.font.kadwa_regular, FontWeight.Normal),
    Font(R.font.kadwa_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = kadwa,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.15.sp
    ),
    titleMedium = TextStyle(
        fontFamily = kadwa,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = kadwa,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.15.sp
    )
)