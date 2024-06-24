package com.example.simpleuserlistapplication.navigation

sealed class Routes(val route: String) {
    object SimpleNameList : Routes("SimpleNameList")
    object Detail : Routes("Detail/{user}")
}