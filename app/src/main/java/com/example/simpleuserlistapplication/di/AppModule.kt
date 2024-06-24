package com.example.simpleuserlistapplication.di

import com.example.simpleuserlistapplication.data.UsersUseCase
import com.example.simpleuserlistapplication.presentation.SimpleNameViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::UsersUseCase)
    viewModelOf(::SimpleNameViewModel)
}