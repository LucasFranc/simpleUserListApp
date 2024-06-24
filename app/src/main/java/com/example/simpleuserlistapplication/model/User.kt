package com.example.simpleuserlistapplication.model

import com.google.gson.annotations.SerializedName

//Using serializedName to possible future integration with proguard/dexguard

data class User(
    @SerializedName("name") val name: String? = null,
    @SerializedName("email") val email: String? = null,
)