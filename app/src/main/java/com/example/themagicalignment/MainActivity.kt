package com.example.themagicalignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.themagicalignment.ui.theme.TheMagicAlignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheMagicAlignmentTheme {
                SelectionOfLayout()
            }
        }
    }
}


@Composable
fun SelectionOfLayout(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(5, 4, 16))
            .paint(
                painterResource(R.drawable.backgroundchoicelayout),
                alpha = 0.1f,
                contentScale = ContentScale.Crop,
            )

    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(R.drawable.navigation_bar),
                contentDescription = "Navigation bar",
                modifier = Modifier.size(390.dp, 71.dp)
            )
            Text(
                text = "Выбор колоды карт",
                fontSize = 22.sp,
                color = Color(255,255,255)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheMagicAlignmentTheme {
        SelectionOfLayout()
    }
}