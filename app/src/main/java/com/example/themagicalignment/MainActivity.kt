package com.example.themagicalignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
fun SelectionOfLayout() {
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
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.navigation_bar),
                contentDescription = "Navigation bar",
                modifier = Modifier.size(390.dp, 71.dp)
            )
            Column(Modifier.padding(horizontal = 24.dp)) {
            Text(
                text = stringResource(R.string.title_deck_selection),
                //fontFamily = manropeFamily,
                //fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 12.dp)
                )
            Text(
                text = stringResource(R.string.text_deck_selection),
                fontSize = 16.sp,
                color = Color.White,
                style = TextStyle(letterSpacing = 0.5.sp),
                lineHeight = 22.sp
            )
            }
            Column(Modifier.padding(start = 24.dp, end = 24.dp, bottom = 36.dp)) {
                ChoiceButton(
                    stringResource(R.string.button_offline_choice_deck),
                    Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(222, 146, 1), RoundedCornerShape(24.dp)),
                    Color(222, 146, 1),
                )
                ChoiceButton(
                    stringResource(R.string.button_online_choice_deck),
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .border(1.dp, Color(222, 146, 1), RoundedCornerShape(24.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color(242, 208, 80), Color(222, 146, 1),
                                )
                            ), RoundedCornerShape(24.dp)
                        )
                )
            }


        }

    }
}

@Composable
fun ChoiceButton(
    textChoiceButton: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = textChoiceButton,
            fontSize = 16.sp,
            color = color,
            modifier = Modifier.padding(0.dp, 13.dp)
        )

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheMagicAlignmentTheme {
        SelectionOfLayout()
    }
}