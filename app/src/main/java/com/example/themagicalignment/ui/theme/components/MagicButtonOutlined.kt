package com.example.themagicalignment.ui.theme.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.ui.theme.Orange

@Composable
fun MagicButtonOutlined(
    onClick : () -> Unit,
    title : String,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier
            .fillMaxWidth()
            .border(1.dp, Orange, RoundedCornerShape(24.dp)),
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = Orange,
            modifier = Modifier.padding(0.dp, 13.dp)
        )
    }
}