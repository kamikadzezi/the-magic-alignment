package ru.magic.ui.contracts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun <STATE,EFFECT,ACTION,CONTRACT : ScreenContract<STATE,EFFECT,ACTION>> ApplicationScreen(
    contract : CONTRACT,
    onEffect : (EFFECT) -> Unit,
    content : @Composable (state: State<STATE>) -> Unit
) {
    val state = contract.container.stateFlow.collectAsState()

    content(state)

    LaunchedEffect(Unit) {
        contract.container.sideEffectFlow.onEach(onEffect).launchIn(this)
    }
}