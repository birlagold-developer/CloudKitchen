package com.kss.cloudkitchen.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kss.cloudkitchen.data.repository.AuthRepository
import com.kss.cloudkitchen.data.repository.RegistrationRepository
import com.kss.cloudkitchen.data.repository.UserRepository
import com.kss.cloudkitchen.ui.main.MainViewModel

class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository  as AuthRepository) as T
          else -> throw IllegalArgumentException("View Model Nt found")
        }
    }

}