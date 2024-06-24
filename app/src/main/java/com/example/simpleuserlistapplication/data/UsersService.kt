package com.example.simpleuserlistapplication.data

import com.example.simpleuserlistapplication.model.User
import retrofit2.http.GET

interface UsersService {
    @GET("users")
    suspend fun getUsers(): List<User>
}