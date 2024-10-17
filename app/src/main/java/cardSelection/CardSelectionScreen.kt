package cardSelection

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.themagicalignment.R
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.ui.theme.ManropeFont
import com.example.themagicalignment.ui.theme.components.MagicBottomAppBar
import com.example.themagicalignment.ui.theme.components.MagicTopAppBar

@Composable
fun CardSelectionScreen(backClick: () -> Unit) {
    Scaffold(topBar = { MagicTopAppBar(backClick) }, bottomBar = { MagicBottomAppBar() }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundBlack)
            .verticalScroll(rememberScrollState(0))
            .padding(it)
    ) {
        Column(Modifier.padding(start = 24.dp, top = 36.dp, end = 24.dp, bottom = 8.dp)) {
            Text(
                text = stringResource(R.string.card_selection_screen_title),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Text(
                text = stringResource(R.string.card_selection_screen_text),
                style = MaterialTheme.typography.bodyLarge
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
            } // TODO-MAIN - При клике на картинку, с описанием колоды

        }
        Spacer(Modifier.height(36.dp))

    }

    }
}


@Composable
fun ImageChoice(
    @DrawableRes image: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(image),
        contentDescription = contentDescription,
        modifier = Modifier
            .padding(top = 16.dp)
            .width(163.dp)
            .height(246.dp) // todo: размеры так никогда больше не выставляем
    )
}

data class CardDeck(
    // временно используем айди ресурса
   @DrawableRes val id : Int,
    val description : String
) // TODO-Main2 - По этой моделе данных сформировать LazyGrid с картами

@Preview(showBackground = true, heightDp = 1500)
@Composable
fun CardSelectionPreview(){
    CardSelectionScreen({})
}

