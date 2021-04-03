package com.kss.cloudkitchen.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kss.cloudkitchen.data.network.Resource
import com.kss.cloudkitchen.data.repository.AuthRepository
import com.kss.cloudkitchen.data.responces.LoginResponse
import com.kss.cloudkitchen.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get

class MainViewModel( private  val repository: AuthRepository
) : BaseViewModel(repository) {
    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
    get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.loading
        _loginResponse.value = repository.login(email, password)
    }

    suspend fun saveAuthToken(token: String)  {
        repository.saveAuthToken(token)
    }

}