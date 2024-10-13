package cardSelection

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.themagicalignment.R
import com.example.themagicalignment.ui.theme.ManropeFont

@Composable
fun CardSelectionScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(5, 4, 16))
            .verticalScroll(rememberScrollState(0))
    ) {

        Image(
            painter = painterResource(R.drawable.top_navigation_bar),
            contentDescription = "Navigation bar",
            modifier = Modifier.size(390.dp, 71.dp)
        )
        Column(Modifier.padding(start = 24.dp, top = 36.dp, end = 24.dp, bottom = 8.dp)) {
            Text(
                text = stringResource(R.string.card_selection_screen_title),
                fontFamily = ManropeFont,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(
                text = stringResource(R.string.card_selection_screen_text),
                fontFamily = ManropeFont,
                fontSize = 16.sp,
                color = Color(181, 181, 183, 204),
                style = TextStyle(letterSpacing = 0.3.sp),
                lineHeight = 22.sp
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
            Column() {
                ImageChoice(R.drawable.frame_1, stringResource(R.string.description_frame_1))
                ImageChoice(R.drawable.frame_3, stringResource(R.string.description_frame_3))
                ImageChoice(R.drawable.frame_5, stringResource(R.string.description_frame_5))
                ImageChoice(R.drawable.frame_7, stringResource(R.string.description_frame_7))
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                ImageChoice(R.drawable.frame_2, stringResource(R.string.description_frame_2))
                ImageChoice(R.drawable.frame_4, stringResource(R.string.description_frame_4))
                ImageChoice(R.drawable.frame_6, stringResource(R.string.description_frame_6))
                ImageChoice(R.drawable.frame_8, stringResource(R.string.description_frame_8))
            }

        }
        Image(
            painter = painterResource(R.drawable.bottom_navigation_bar),
            contentDescription = stringResource(R.string.navigation_buttom),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .height(60.dp)
        )

    }

}


@Composable
fun ImageChoice(@DrawableRes image: Int, contentDescription: String) {
    Image(
        painter = painterResource(image),
        contentDescription = contentDescription,
        modifier = Modifier
            .padding(top = 16.dp)
            .width(163.dp)
            .height(246.dp)
    )
}

