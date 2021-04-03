package com.kss.cloudkitchen.data.repository

import com.kss.cloudkitchen.data.network.AuthApi
import com.kss.cloudkitchen.data.preferences.UserPreferences
import com.kss.cloudkitchen.ui.base.BaseRepository


class  AuthRepository(
    private val api : AuthApi,
    private val preferences: UserPreferences
): BaseRepository(){
    suspend fun login(
        email : String ,
        password: String
    )= safeApiCall { api.login(email,password) }


    suspend fun saveAuthToken(token:String)
    {
        preferences.saveAuthToken(token)
    }
}