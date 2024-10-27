package ru.magic.ui.contracts.sample

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import ru.magic.ui.contracts.sample.orbit.SampleContract

class SampleViewModel : ViewModel(), SampleContract {
    override val container: Container<SampleContract.SampleState, SampleContract.SampleEffect>
        = container(SampleContract.SampleState.initial())

    override fun action(action: SampleContract.SampleAction) {
        when(action) {
            is SampleContract.SampleAction.OnLoinChanged -> onLoginChanged(action.login)
        }
    }

    private fun onLoginChanged(value: String) = blockingIntent {
        reduce { state.copy(login = value) }
    }
}