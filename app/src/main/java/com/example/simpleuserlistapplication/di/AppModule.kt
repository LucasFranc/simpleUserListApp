package com.example.simpleuserlistapplication.di

import com.example.simpleuserlistapplication.presentation.SimpleNameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SimpleNameViewModel(get()) }
}

