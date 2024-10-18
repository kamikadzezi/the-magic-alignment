package cardSelection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.themagicalignment.CardDeck
import com.example.themagicalignment.R
import com.example.themagicalignment.ui.theme.BackgroundBlack
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 36.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = false,
            modifier = Modifier.heightIn(max = 5000.dp)
        ) {
            items(CardDeckInitList()) { deck ->
                ButtonImage(deck.id, deck.description,{})
            }
        }


        // *TODO-MAIN - При клике на картинку, с описанием колоды


    }

    }
}

fun CardDeckInitList(): List<CardDeck> {
    return listOf(
        CardDeck(R.drawable.frame_1, "deck_1",),
        CardDeck(R.drawable.frame_2, "deck_2",),
        CardDeck(R.drawable.frame_3, "deck_3"),
        CardDeck(R.drawable.frame_4, "deck_4"),
        CardDeck(R.drawable.frame_5, "deck_5"),
        CardDeck(R.drawable.frame_6, "deck_6"),
        CardDeck(R.drawable.frame_7, "deck_7"),
        CardDeck(R.drawable.frame_8, "deck_8")
    )
}
@Composable
fun ButtonImage(
    id: Int,
    description: String,
    onClick:()->Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id), description, modifier = Modifier
            .width(163.dp)
            .height(246.dp)
            .clickable {onClick })
    }

}

// *TODO-Main2 - По этой моделе данных сформировать LazyGrid с картами

@Preview(heightDp = 1500)
@Composable
fun CardSelectionPreview(){
    CardSelectionScreen({})
}

