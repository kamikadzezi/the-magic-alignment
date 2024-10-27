package com.example.themagicalignment.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    fun onLoginUpdate(value:String) {
        _login.value = value
    }
    fun onPasswordUpdate(value: String){
        _password.value = value
    }
    fun userDataVerification(): Boolean{
         return userRepository.fetchUserData().login==_login.value && userRepository.fetchUserData().password==_password.value

    }

}