package com.movies.ui.compose.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Created by Pranav Bhoraskar
 */

@Composable
fun TextAtomRegular(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    textAlignCenter: Boolean = true
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.W300,
            fontSize = fontSize
        ),
        textAlign = if (textAlignCenter) TextAlign.Center else TextAlign.Start,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TextAtomMedium(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    textAlignCenter: Boolean = true
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.W400,
            fontSize = fontSize
        ),
        textAlign = if (textAlignCenter) TextAlign.Center else TextAlign.Start,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TextAtomBold(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    textAlignCenter: Boolean = true
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.W700,
            fontSize = fontSize
        ),
        textAlign = if (textAlignCenter) TextAlign.Center else TextAlign.Start,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TextAtomRegularMultipleLines(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    textAlignCenter: Boolean = true
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.W300,
            fontSize = fontSize
        ),
        textAlign = if (textAlignCenter) TextAlign.Center else TextAlign.Justify
    )
}