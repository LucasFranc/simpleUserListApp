package com.example.simpleuserlistapplication.data

import com.example.simpleuserlistapplication.model.User

class UsersRepository (private val usersService: UsersService) {

    suspend fun getUsers(): List<User> {
         return usersService.getUsers()
    }
}