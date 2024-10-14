package com.example.themagicalignment.ui.theme.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.themagicalignment.ui.theme.ManropeFont

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
            .border(1.dp, Color(222, 146, 1), RoundedCornerShape(24.dp)),
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            text = title,
            fontFamily = ManropeFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color(222, 146, 1),
            modifier = Modifier.padding(0.dp, 13.dp)
        ) // TODO # - Скомпоновоть шрифт, размер, цвета в TextStyle,
    }
}