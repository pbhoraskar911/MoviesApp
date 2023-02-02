package com.movies.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.movies.R

/**
 * Created by Pranav Bhoraskar
 */

val MoviesFontFamily = FontFamily(
    Font(R.font.dmsans_bold, FontWeight.Bold),
    Font(R.font.dmsans_medium,FontWeight.Medium),
    Font(R.font.dmsans_regular,FontWeight.Normal)
)
val MoviesTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = MoviesFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
    )
    // TODO - add more textstyles here
)

