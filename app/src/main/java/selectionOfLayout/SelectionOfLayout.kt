package selectionOfLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.themagicalignment.R
import com.example.themagicalignment.Screen
import com.example.themagicalignment.ui.theme.ManropeFont

@Composable
fun SelectionOfLayout(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(5, 4, 16))
            .paint(
                painterResource(R.drawable.backgroundchoicelayout),
                alpha = 0.1f,
                contentScale = ContentScale.Crop,
            )
    ) {
            Image(
                painter = painterResource(R.drawable.top_navigation_bar),
                contentDescription = "Navigation bar",
                modifier = Modifier.size(390.dp, 71.dp)
            )
            Column(Modifier.padding(horizontal = 24.dp)) {
                Text(
                    text = stringResource(R.string.title_deck_selection),
                    fontFamily = ManropeFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                Text(
                    text = stringResource(R.string.text_deck_selection),
                    fontFamily = ManropeFont,
                    fontSize = 16.sp,
                    color = Color(181,181,183),
                    style = TextStyle(letterSpacing = 0.5.sp),
                    lineHeight = 22.sp
                )
            }
            Column(Modifier.padding(start = 24.dp, end = 24.dp, bottom = 36.dp)) {
                TextButton(
                    onClick = { navController.navigate(route = Screen.SecondScreen.route) },
                    Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(222, 146, 1), RoundedCornerShape(24.dp)),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_offline_choice_deck),
                        fontFamily = ManropeFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color(222, 146, 1),
                        modifier = Modifier.padding(0.dp, 13.dp)
                    )
                }
                TextButton(
                    onClick = { },
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color(242, 208, 80), Color(222, 146, 1),
                                )
                            ), RoundedCornerShape(24.dp)
                        ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_online_choice_deck),
                        fontFamily = ManropeFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(0.dp, 13.dp)
                    )
                }

            }


        }

    }








