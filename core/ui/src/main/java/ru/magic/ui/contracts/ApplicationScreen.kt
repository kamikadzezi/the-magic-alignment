package ru.magic.ui.contracts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun <STATE,EFFECT,ACTION,CONTRACT : ScreenContract<STATE,EFFECT,ACTION>> ApplicationScreen(
    contract : CONTRACT,
    onEffect : (EFFECT) -> Unit,
    content : @Composable (state: STATE) -> Unit
) {
    val state by contract.container.stateFlow.collectAsState()

    content(state)

    LaunchedEffect(Unit) {
        contract.container.sideEffectFlow.onEach(onEffect).launchIn(this)
    }
}