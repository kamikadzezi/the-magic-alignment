package selectionOfLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.themagicalignment.R
import com.example.themagicalignment.Screen
import com.example.themagicalignment.ui.theme.ManropeFont
import com.example.themagicalignment.ui.theme.components.MagicButtonOutlined

@Composable
fun SelectionOfLayout( //
    onChooseCardScreen: () -> Unit,
) {
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
                modifier = Modifier.fillMaxWidth().height(56.dp) // TODO #2 - Исправить размеры при реалзиации компонтентов
            ) // TODO #1 - Удалить из проекта такого рода реализацию апп бара, использовать кастомнпый TopAppBar с кликами, тайтлом, иконками
            Column(Modifier.padding(horizontal = 24.dp)) {
                Text(
                    text = stringResource(R.string.title_deck_selection),
                    fontFamily = ManropeFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.text_deck_selection),
                    fontFamily = ManropeFont,
                    fontSize = 16.sp,
                    color = Color(181,181,183), // TODO #6 - Постараться внедрить цвета в дизайн схему
                    style = TextStyle(letterSpacing = 0.5.sp),
                    lineHeight = 22.sp
                )
            }
            Column(Modifier.padding(start = 24.dp, end = 24.dp, bottom = 36.dp)) {
                MagicButtonOutlined(
                    onClick = onChooseCardScreen ,
                    title = stringResource(R.string.button_offline_choice_deck)
                )
                TextButton( // TODO #5 - Сделать Filled кнопку, с учетом улучшений из Outlined кнопки
                    onClick = { }, // TODO #6 - Добавить переход на экран выбора колоды
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
@Preview(showBackground = true)
@Composable
fun SelectionOfLayout(){
    SelectionOfLayout(onChooseCardScreen = { })
}








