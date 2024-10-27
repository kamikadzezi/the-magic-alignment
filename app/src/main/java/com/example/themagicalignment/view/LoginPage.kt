package com.example.themagicalignment.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import kotlin.coroutines.jvm.internal.CompletedContinuation.context
import kotlin.math.log


@Composable
fun LoginPage(modifier: Modifier = Modifier, viewModel: LoginViewModel) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = BackgroundBlack)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

        OutlinedTextField(value = viewModel.login.value , onValueChange = viewModel::onLoginUpdate,Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = viewModel.password.value , onValueChange = viewModel::onPasswordUpdate,Modifier.fillMaxWidth())
        Button(onClick = {
        if (viewModel::userDataVerification.isFinal){

        }    else {
            Toast.makeText(
                get,
                "Пожалуйста введите логин и пароль",
                Toast.LENGTH_SHORT
            ).show()
            }

        },Modifier.fillMaxWidth()) {Text(text = "Войти")}


        }


    }


@Preview(showBackground = true)
@Composable
fun ShowLoginPage() {
    LoginPage(viewModel = LoginViewModel(),)
}
