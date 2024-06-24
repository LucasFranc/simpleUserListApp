package com.example.simpleuserlistapplication.presentation

import com.example.simpleuserlistapplication.model.User

data class UserState(
    val loading: Boolean = true,
    val users: List<User>? = null,
    val error: String? = null
)