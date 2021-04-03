package com.kss.cloudkitchen.ui.base

import androidx.lifecycle.ViewModel
import com.kss.cloudkitchen.data.network.UserApi

abstract class BaseViewModel(
    private val repository: BaseRepository
): ViewModel(){
    /*suspend fun logout(api: UserApi)= repository.logout(api)*/
}