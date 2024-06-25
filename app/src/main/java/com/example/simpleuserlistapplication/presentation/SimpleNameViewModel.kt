package com.example.simpleuserlistapplication.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleuserlistapplication.data.UsersUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject
import java.lang.Exception


class SimpleNameViewModel(private val usersUseCase: UsersUseCase) : ViewModel() {

    private val _userState = mutableStateOf(UserState())
    val userState: State<UserState> = _userState
    val delayTime = 1000L

    init {
        viewModelScope.launch {
            try {
                delay(delayTime) // little delay only to show you guys the loading :)
                val response = usersUseCase.getUsers()
                _userState.value = _userState.value.copy(
                    users = response,
                    loading = false,
                    error = null
                )

            } catch (e: Exception) {
                _userState.value = _userState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }
}