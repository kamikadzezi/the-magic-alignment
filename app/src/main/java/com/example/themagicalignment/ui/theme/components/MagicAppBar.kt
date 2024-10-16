package com.example.themagicalignment.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.themagicalignment.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MagicTopAppBar(onClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = painterResource(
                        R.drawable.arrow_vtcm7ttmzwqj
                    ),
                    contentDescription = stringResource(R.string.content_description_arrow_back_top_bar),

                )
            }
        },
        title = {})
}

@Composable
fun MagicBottomAppBar() {
    NavigationBar(containerColor = Color(0x66000000)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.homenavigation),
                    contentDescription = stringResource(R.string.content_description_home_bottom_bar)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.card_navigation),
                    contentDescription = stringResource(R.string.content_description_card_bottom_bar)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.circle_navigation),
                    contentDescription = stringResource(R.string.content_description_circle_bottom_bar)
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.book_navigation),
                    contentDescription = stringResource(R.string.content_description_book_bottom_bar)
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MagicAppBarPreview() {
    MagicBottomAppBar()
}