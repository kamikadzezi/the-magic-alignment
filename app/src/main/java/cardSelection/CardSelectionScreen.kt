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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.themagicalignment.CardDeck
import com.example.themagicalignment.R
import com.example.themagicalignment.Screen
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.ui.theme.components.MagicBottomAppBar
import com.example.themagicalignment.ui.theme.components.MagicTopAppBar

@Composable
fun CardSelectionScreen(NavigateBack: () -> Unit, NavigationCardDescription: NavController) {
    Scaffold(topBar = { MagicTopAppBar(NavigateBack) }, bottomBar = { MagicBottomAppBar() }) {
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
                ButtonImage(deck.id, deck.textTitle, deck.textBody, NavigationCardDescription)
            }
        }


        // *TODO-MAIN - При клике на картинку, с описанием колоды


    }

    }
}


fun CardDeckInitList(): List<CardDeck> {
    return listOf(
        CardDeck(
            R.drawable.frame_1,
            R.string.title_deck_description_2,
            R.string.body_deck_description_2
        ),
        CardDeck(
            R.drawable.frame_2,
            R.string.title_deck_description_2,
            R.string.body_deck_description_2
        ),
        CardDeck(
            R.drawable.frame_3,
            R.string.title_deck_description_3,
            R.string.body_deck_description_3
        ),
        CardDeck(
            R.drawable.frame_4,
            R.string.title_deck_description_4,
            R.string.body_deck_description_4
        ),
        CardDeck(
            R.drawable.frame_5,
            R.string.title_deck_description_2,
            R.string.body_deck_description_2
        ),
        CardDeck(
            R.drawable.frame_6,
            R.string.title_deck_description_2,
            R.string.body_deck_description_2
        ),
        CardDeck(
            R.drawable.frame_7,
            R.string.title_deck_description_2,
            R.string.body_deck_description_2
        ),
        CardDeck(
            R.drawable.frame_8,
            R.string.title_deck_description_2,
            R.string.body_deck_description_2
        )
    )
}
@Composable
fun ButtonImage(
    id: Int,
    textTitle: Int,
    textBody: Int,
    navController: NavController
) {
    Box(contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id), stringResource(textTitle), modifier = Modifier
            .width(163.dp)
            .height(246.dp)
            .clickable { navController.navigate(Screen.DeckDescription.route + "/$textTitle/$textBody/$id") })
    }

}
@Preview(heightDp = 1500)
@Composable
fun CardSelectionPreview(){
    CardSelectionScreen({}, rememberNavController())
}

