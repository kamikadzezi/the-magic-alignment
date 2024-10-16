package com.example.themagicalignment.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.R

//TODO #8 - Сделайть кастом AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MagicAppBar(onClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = painterResource(
                        R.drawable.arrow_vtcm7ttmzwqj
                    ), contentDescription = "arrow",

                )
            }
        },
        title = {})
}

@Preview(showBackground = true)
@Composable
fun MagicAppBarPreview() {
    MagicAppBar {}
}