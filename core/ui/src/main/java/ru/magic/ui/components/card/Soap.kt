package ru.magic.ui.components.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Модель для описания расклада
data class CardPosition(
    val row: Int,
    val column: Int,
    val offsetX: Float = 0.2f,
    val offsetY: Float = 0f,
    val rotation: Float = 0f,
)
data class SpreadLayout(
    val name: String,
    val positions: List<CardPosition>,
    val rows: Int,
    val columns: Int
)

// Пример данных для предустановленных раскладов
val preDefinedSpreads = listOf(
    SpreadLayout(
        name = "Будущее в ситуации",
        positions = listOf(CardPosition(0, 1), CardPosition(1, 0), CardPosition(1, 1), CardPosition(1, 2)),
        rows = 2,
        columns = 3
    ),
    SpreadLayout(
        name = "Отношения с коллегами",
        positions = listOf(
            CardPosition(0, 0), CardPosition(0, 1),
            CardPosition(1, 0), CardPosition(1, 1),
            CardPosition(2, 0), CardPosition(2, 1)
        ),
        rows = 3,
        columns = 2
    ),
    SpreadLayout(
        name = "Кельтский крест",
        positions = listOf(
            CardPosition(1, 1), // Карта 1 - центр креста
            CardPosition(1, 1), // Карта 2 - пересекает первую
            CardPosition(0, 1), // Карта 3 - над первой картой
            CardPosition(2, 1), // Карта 4 - под первой картой
            CardPosition(1, 0), // Карта 5 - слева от первой карты
            CardPosition(1, 2), // Карта 6 - справа от первой карты
            CardPosition(0, 3), // Карта 7 - правая колонка, верх
            CardPosition(1, 3), // Карта 8 - правая колонка, второй сверху
            CardPosition(2, 3), // Карта 9 - правая колонка, второй снизу
            CardPosition(3, 3)  // Карта 10 - правая колонка, низ
        ),
        rows = 4,
        columns = 4
    ),
    SpreadLayout(
        name = "Партнер",
        positions = listOf(
            CardPosition(0, 0), // Карта 1 - верхний левый угол
            CardPosition(0, 2), // Карта 2 - верхний правый угол
            CardPosition(1, 1), // Карта 3 - центр
            CardPosition(2, 0), // Карта 4 - нижний левый угол
            CardPosition(2, 2)  // Карта 5 - нижний правый угол
        ),
        rows = 3,
        columns = 3
    )

    // Добавьте другие расклады аналогичным образом
)

// Универсальная Composable функция для отрисовки расклада
@Composable
fun SpreadView(
    spreadLayout: SpreadLayout,
    cardSize: Dp = 60.dp,
    spacing: Dp = 8.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.surface
) {
    Box(
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            for (row in 0 until spreadLayout.rows) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(spacing),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    for (column in 0 until spreadLayout.columns) {
                        if (spreadLayout.positions.contains(CardPosition(row, column))) {
                            Soap()
                        } else {
                            Spacer(modifier = Modifier.size(width = 32.dp, height = 48.dp)) // Пустое место, если карты нет
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Soap() {
    Canvas(modifier = Modifier.size(width = 32.dp, height = 48.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRect(
            color = Color.Cyan,
            size = size.copy(width = canvasWidth / 2, height = canvasHeight / 2)
        )
    }
}

@Composable
fun TarotCardPlaceholder(cardSize: Dp) {
    Card(
        modifier = Modifier.size(cardSize).background(Color.White),
        shape = RoundedCornerShape(8.dp),
    ) {
        // Placeholder для карты, можно заменить на реальный UI карты
    }
}

@Composable
fun SpreadSelectionScreen(spreads: List<SpreadLayout>) {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        for (spread in spreads) {
            SpreadView(spreadLayout = spread, cardSize = 60.dp, spacing = 8.dp)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun PreviewSpreadSelectionScreen() {
    SpreadSelectionScreen(spreads = preDefinedSpreads)
}