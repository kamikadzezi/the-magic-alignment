package selectionOfLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.R
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.ui.theme.components.MagicButtonFilled
import com.example.themagicalignment.ui.theme.components.MagicButtonOutlined
import com.example.themagicalignment.ui.theme.components.MagicTopAppBar

@Composable
fun SelectionOfLayout(
    //
    onChooseCardScreen: () -> Unit,
) {
    Scaffold(topBar = { MagicTopAppBar({}) }) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(color = BackgroundBlack)
                .paint(
                    painterResource(R.drawable.backgroundchoicelayout),
                    alpha = 0.1f,
                    contentScale = ContentScale.Crop,
                )
                .padding(it)
        ) {
            Spacer(Modifier.height(0.dp))
            Column(Modifier.padding(horizontal = 24.dp)) {
                Text(
                    text = stringResource(R.string.title_deck_selection),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.text_deck_selection),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column(Modifier.padding(start = 24.dp, end = 24.dp, bottom = 36.dp)) {
                MagicButtonOutlined(
                    onClick = onChooseCardScreen,
                    title = stringResource(R.string.button_offline_choice_deck)
                )
                MagicButtonFilled(
                    onClick = {},
                    title = stringResource(R.string.button_online_choice_deck),
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectionOfLayout() {
    SelectionOfLayout(onChooseCardScreen = { })
}








