package com.example.themagicalignment.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themagicalignment.R
import com.example.themagicalignment.ui.theme.BackgroundBlack
import com.example.themagicalignment.viewmodel.LoginViewModel
import kotlinx.coroutines.launch


@Composable
fun LoginPage(modifier: Modifier = Modifier, viewModel: LoginViewModel) {
    val context = LocalContext.current
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    Scaffold(snackbarHost = { SnackbarHost(snackBarHostState) }) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = BackgroundBlack)
                .padding(horizontal = 24.dp)
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

        OutlinedTextField(value = viewModel.login.value , onValueChange = viewModel::onLoginUpdate,Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = viewModel::onPasswordUpdate,
                Modifier.fillMaxWidth(),
                visualTransformation = if (viewModel.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (viewModel.passwordVisible.value) {
                        painterResource(R.drawable.baseline_visibility_24)
                    } else {
                        painterResource(R.drawable.baseline_visibility_off_24)
                    }
                    IconButton(onClick = { viewModel.onPasswordVisibleUpdate() }) {
                        Icon(painter = image, "")
                    }
                })
            Spacer(Modifier.height(16.dp))
        Button(onClick = {
            if (viewModel.login.value.isNotBlank() && viewModel.password.value.isNotBlank()) {
                focusManager.clearFocus()
                if (viewModel.userDataVerification()) {
                    scope.launch {
                        snackBarHostState.showSnackbar("Ok", actionLabel = "ok")
                    }
                } else {
                    scope.launch {
                        snackBarHostState.showSnackbar("Не ок", actionLabel = "ok")
                    }
                }
            } else {
            Toast.makeText(
                context,
                "Пожалуйста введите логин и пароль",
                Toast.LENGTH_SHORT
            ).show()
            }
        },Modifier.fillMaxWidth()) {Text(text = "Войти")}
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowLoginPage() {
    LoginPage(viewModel = LoginViewModel(),)
}
