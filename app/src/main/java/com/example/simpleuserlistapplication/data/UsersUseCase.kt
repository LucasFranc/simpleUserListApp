package com.example.simpleuserlistapplication.data

import com.example.simpleuserlistapplication.model.User

class UsersUseCase (private val usersRepository: UsersRepository) {

    suspend fun getUsers(): List<User> {
         return usersRepository.getUsers()
    }
}