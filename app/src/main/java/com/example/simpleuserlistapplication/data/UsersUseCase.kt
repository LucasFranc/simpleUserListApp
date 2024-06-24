package com.example.simpleuserlistapplication.data

import com.example.simpleuserlistapplication.model.User

class UsersUseCase {
    // if i do have more requests for users, i would put here with new suspend functions
    suspend fun getUsers(): List<User> {
         return RetrofitClient.getClient().create(UsersService::class.java).getUsers()
    }
}