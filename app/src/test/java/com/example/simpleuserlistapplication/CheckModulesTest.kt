package com.example.simpleuserlistapplication

import com.example.simpleuserlistapplication.data.UsersRepository
import com.example.simpleuserlistapplication.data.UsersService
import com.example.simpleuserlistapplication.data.UsersUseCase
import com.example.simpleuserlistapplication.di.appModule
import com.example.simpleuserlistapplication.di.networkModule
import okhttp3.OkHttpClient
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.verify.verify
import retrofit2.Retrofit

@Category(CheckModuleTest::class)
class CheckModulesTest : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules(){
        appModule.verify(
            extraTypes = listOf(
                UsersUseCase::class
            )
        )
        networkModule.verify()
    }
}