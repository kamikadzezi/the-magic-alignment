package com.example.themagicalignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.ui.theme.components.MagicButtonFilled
import com.example.themagicalignment.ui.theme.components.MagicTopAppBar

@Composable
fun DeckDescription(backClick: () -> Unit,textTitle: Int,textBody: Int,imageDeck: Int) {
    val imageDescription = textTitle
    Scaffold(topBar = { MagicTopAppBar(backClick) }){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundBlack)
            .padding(paddingValues = it)
            .padding(start = 24.dp, top = 36.dp, end = 24.dp, bottom = 36.dp), verticalArrangement = Arrangement.SpaceBetween) {
        Column() {
            Text(
                text = stringResource(textTitle),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Row {
                Image(painterResource(imageDeck), contentDescription = stringResource(imageDescription), modifier = Modifier
                    .height(246.dp)
                    .width(163.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(textBody),
                    style = MaterialTheme.typography.bodyLarge
                )
            }}
            MagicButtonFilled({}, stringResource(R.string.button_deck_description))

        }
    }}

