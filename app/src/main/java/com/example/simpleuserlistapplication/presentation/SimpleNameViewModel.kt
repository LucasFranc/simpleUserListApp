package com.example.simpleuserlistapplication.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleuserlistapplication.data.UsersUseCase
import com.example.simpleuserlistapplication.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SimpleNameViewModel(private val usersUseCase: UsersUseCase) : ViewModel() {

    private val _userState = mutableStateOf(UserState())
    val userState: State<UserState> = _userState
    private val delayTime = 1000L

    init {
        viewModelScope.launch {
            try {
                delay(delayTime) // little delay only to show you guys the loading :)
                val response = usersUseCase.getUsers()
                if (validateResponseEmail(response)) {
                    _userState.value = _userState.value.copy(
                        users = response,
                        loading = false,
                        error = null
                    )
                }else{
                    throw Exception("Error in e-mail Regex")
                }
            } catch (e: Exception) {
                _userState.value = _userState.value.copy(
                    loading = false,
                    error = "Error fetching Users ${e.message}"
                )
            }
        }
    }

    fun validateResponseEmail(response: List<User>): Boolean {
        for (user in response) {
            if (user.email?.let { PatternsCompat.EMAIL_ADDRESS.matcher(it).matches() } != true) {
                return false
            }
        }
        return true
    }
}