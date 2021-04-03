package com.kss.cloudkitchen.data.repository

import com.kss.cloudkitchen.data.network.UserApi
import com.kss.cloudkitchen.ui.base.BaseRepository


class UserRepository(
    private val api : UserApi
) : BaseRepository(){
    suspend fun getUser() = safeApiCall {
        api.getUser()
    }

}