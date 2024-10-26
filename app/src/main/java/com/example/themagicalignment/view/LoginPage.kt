package com.example.themagicalignment.view

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.R
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.viewmodel.HomeViewModel
import kotlin.math.roundToInt


@Composable
fun LoginPage(modifier: Modifier = Modifier, viewModel: HomeViewModel,on:Boolean) {
    val userData = viewModel.userData.observeAsState()
    var moved by remember { mutableStateOf(true) }
    val pxToMove = with(LocalDensity.current) {
        -462.dp.toPx().roundToInt()
    }
    val offset by animateIntOffsetAsState(
        targetValue = if (!moved) {
            IntOffset(x = 0, y = pxToMove)
        } else {
            IntOffset.Zero
        },
        animationSpec = tween(800, easing = FastOutSlowInEasing), label = ""
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = BackgroundBlack),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (on){
        Image(
            painter = painterResource(R.drawable.backgroundchoicelayout),
            contentDescription = "login_page",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .wrapContentSize(unbounded = true, align = Alignment.Center)
                .size(844.dp)
                .offset { offset }
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    enabled = moved
                ) { moved = !moved })
    }


}}

@Preview(showBackground = true)
@Composable
fun ShowLoginPage() {
    LoginPage(viewModel = HomeViewModel(), on = false)
}