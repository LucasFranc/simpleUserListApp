package com.example.simpleuserlistapplication

import com.example.simpleuserlistapplication.di.appModule
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.verify.verify

@Category(CheckModuleTest::class)
class CheckModulesTest : KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules(){
        appModule.verify()
    }
}