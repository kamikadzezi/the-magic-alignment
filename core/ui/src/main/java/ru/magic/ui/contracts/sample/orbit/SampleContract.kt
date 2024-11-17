package ru.magic.ui.contracts.sample.orbit

import ru.magic.ui.contracts.ContainerContract
import ru.magic.ui.contracts.ScreenContract



interface SampleContract : ScreenContract<SampleContract.SampleState,SampleContract.SampleEffect,SampleContract.SampleAction> {
    data class SampleState(
        val login : String
    ) : ContainerContract.StateContract() {
        companion object {
            fun initial() = SampleState("")
        }
    }

    sealed interface SampleAction : ContainerContract.ActionContract {
        class OnLoinChanged(val login: String) : SampleAction
    }

    sealed class SampleEffect : ContainerContract.EffectContract {
        class ContainsHui : SampleEffect()
    }
}