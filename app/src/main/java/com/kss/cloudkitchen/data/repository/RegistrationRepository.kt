package com.kss.cloudkitchen.data.repository

import com.kss.cloudkitchen.data.network.AuthApi
import com.kss.cloudkitchen.ui.base.BaseRepository


class RegistrationRepository(
    private val api : AuthApi
): BaseRepository() {
    suspend fun signup(
        name: String,
        email: String,
        password: String,
        confirmpassword: String
    )=safeApiCall { api.signup(name,email,password,confirmpassword) }

}