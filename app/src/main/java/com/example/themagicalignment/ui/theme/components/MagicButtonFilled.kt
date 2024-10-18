package com.example.themagicalignment.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.ui.theme.GradientButtomEnd
import com.example.themagicalignment.ui.theme.GradientButtomStart

@Composable
fun MagicButtonFilled(
    onClick : () -> Unit,
    title : String,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick, //
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        GradientButtomStart, GradientButtomEnd,
                    )
                ), RoundedCornerShape(24.dp)
            ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 13.dp)
        )
    }
}
