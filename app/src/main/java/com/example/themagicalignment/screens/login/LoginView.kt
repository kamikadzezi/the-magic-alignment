package com.example.themagicalignment.screens.login

import androidx.lifecycle.ViewModel
import com.example.themagicalignment.screens.login.orbit.SideEffect
import com.example.themagicalignment.screens.login.orbit.State
import org.orbitmvi.orbit.ContainerHost

class LoginModel: ContainerHost<State, SideEffect>, ViewModel() {

}