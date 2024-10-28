package com.example.themagicalignment.viewmodel

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themagicalignment.model.UserData
import com.example.themagicalignment.model.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    private val userRepository: UserRepository = UserRepository()
    private val _login = mutableStateOf("")
    val login : State<String> = _login
    private val _password = mutableStateOf("")
    val password : State<String> = _password
    private val _passwordVisible = mutableStateOf(false)
    val passwordVisible : State<Boolean> = _passwordVisible
    fun onLoginUpdate(value:String) {
        _login.value = value
    }
    fun onPasswordUpdate(value: String){
        _password.value = value
    }
    fun onPasswordVisibleUpdate(){
        _passwordVisible.value = !_passwordVisible.value
    }
    fun userDataVerification(): Boolean{
         return userRepository.fetchUserData().login==_login.value.trim() && userRepository.fetchUserData().password==_password.value.trim()
    }

}