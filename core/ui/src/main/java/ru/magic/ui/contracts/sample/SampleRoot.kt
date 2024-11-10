package ru.magic.ui.contracts.sample

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import ru.magic.ui.contracts.ApplicationScreen
import ru.magic.ui.contracts.sample.orbit.SampleContract

@Composable
fun SampleRoot(
    contract: SampleContract
) {
    ApplicationScreen(
        contract = contract,
        onEffect = remember {{ effect ->
            when(effect) {
                else -> Unit
            }
        }},
    ) { state ->
        TextField(
            value = state.value.login,
            onValueChange = remember {{ login ->
                contract.action(SampleContract.SampleAction.OnLoinChanged(login))
            }}
        )
    }
} // тут вызывается SampleScreen