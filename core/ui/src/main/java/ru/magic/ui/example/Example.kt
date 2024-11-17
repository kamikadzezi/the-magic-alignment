package ru.magic.ui.example

import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import ru.magic.ui.contracts.ApplicationScreen
import ru.magic.ui.contracts.ContainerContract
import ru.magic.ui.contracts.ScreenContract

interface Car {
    val color : Color

    fun drive()
    fun bip()
}

interface Ford: Car {
    val emblemImage : String
}

class Fusion : Ford {

    override val emblemImage: String
        get() = TODO("Not yet implemented")

    override val color: Color
        get() = TODO("Not yet implemented")

    override fun drive() {
        TODO("Not yet implemented")
    }

    override fun bip() {
        TODO("Not yet implemented")
    }

}

class Mustang : Ford {

    override val emblemImage: String
        get() = TODO("Not yet implemented")

    override val color: Color
        get() = TODO("Not yet implemented")

    override fun drive() {
        TODO("Not yet implemented")
    }

    override fun bip() {
        TODO("Not yet implemented")
    }
}



// JAVA-VIRTUAL-MACHINE
// Clean Arch || Uncle Bob
// SOLID
// S - Принцип единой отвественности
// Main Thread -- UI Thread

// Model ViewModel View
// MVVM+
// Model View Intent

private object ExampleRepository {
    fun example() : String = this::class.java.name
    private var DEFAULT_INPUT = "ttt"

    fun login(username: String, password : String) : Boolean
        = (username == DEFAULT_INPUT && password == DEFAULT_INPUT)

    suspend fun updateDefaultInput() {
        DEFAULT_INPUT = "ttt1"
    }


}

interface ExampleContract : ScreenContract<ExampleContract.State, ExampleContract.Effect, ExampleContract.Action> {

    data class State(
        val login : String,
        val password: String,
    ) : ContainerContract.StateContract() {
        fun initial() = State("", "")
        companion object {
            fun initial() = State("", "")
        }
    }

    sealed interface Action : ContainerContract.ActionContract {
        class OnLoginChanged(val login: String) : Action
        class OnPasswordChanged(val password: String) : Action
        object OnUpdateDefaultInput : Action
        object OnLogin : Action
    }

    sealed class Effect : ContainerContract.EffectContract {
        object DefaultUpdated : Effect()
        object LoginSuccess : Effect()
        object LoginFailed : Effect()
    }
}

class Example : ViewModel(), ExampleContract {
    private val repository = ExampleRepository // model || data layer

    override val container: Container<ExampleContract.State, ExampleContract.Effect>
        = container(ExampleContract.State.initial())

    override fun action(action: ExampleContract.Action) {
        when(action) {
            ExampleContract.Action.OnLogin -> login()
            is ExampleContract.Action.OnLoginChanged -> updateLogin(action.login)
            is ExampleContract.Action.OnPasswordChanged -> updatePassword(action.password)
            ExampleContract.Action.OnUpdateDefaultInput -> updateDefaultInput()
        }
    }

    private fun updateLogin(login : String) = blockingIntent {
        reduce { state.copy(login = login) }
    }

    private fun updatePassword(password : String) = blockingIntent {
        reduce { state.copy(password = password) }
    }

    private fun login()  = intent {
        repository.login(state.login, state.password).let { result ->
            if (result) {
                postSideEffect(ExampleContract.Effect.LoginSuccess)
            } else {
                postSideEffect(ExampleContract.Effect.LoginFailed)
            }
        }
    }

    private fun updateDefaultInput() = intent  {
        repository.updateDefaultInput().let {
            postSideEffect(ExampleContract.Effect.DefaultUpdated)
        }
    }

}

@Composable
fun ExampleRoot(contract: ExampleContract, onNavigateBack: () -> Unit) {

    val context = LocalContext.current

    ApplicationScreen(
        contract = contract,
        onEffect = { sideEffect ->
            when(sideEffect) {
                ExampleContract.Effect.DefaultUpdated -> onNavigateBack()
                ExampleContract.Effect.LoginFailed -> Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                ExampleContract.Effect.LoginSuccess -> Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
            }
        }
    ) { state ->
       ExampleScreen(
           state = state,
           action = contract::action
       )
    }
}

@Composable
fun ExampleScreen(
    state : ExampleContract.State,
    action : (ExampleContract.Action) -> Unit
) {
    Column {
        // login
        TextField(
            value = state.login,
            onValueChange = { login ->
                action(ExampleContract.Action.OnLoginChanged(login))
            }
        )
        // password
        TextField(
            value = state.password,
            onValueChange = { password ->
                action(ExampleContract.Action.OnPasswordChanged(password))
            }
        )
        // login button
        Button(
            onClick = {
                action(ExampleContract.Action.OnLogin)
            },
            modifier = Modifier.fillMaxWidth().height(100.dp),
            content = { Unit }
        )
        //updateInput
        Button(
            onClick = {
                action(ExampleContract.Action.OnUpdateDefaultInput)
            },
            modifier = Modifier.fillMaxWidth().height(100.dp),
            content = { Unit }
        )
    }
}

@Preview
@Composable
fun PreviewExampleScreen() {
    ExampleScreen(
        state = ExampleContract.State.initial().copy("login", "password"),
        action = {}
    )
}