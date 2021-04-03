package com.kss.cloudkitchen.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.kss.cloudkitchen.R
import com.kss.cloudkitchen.data.preferences.UserPreferences
import com.kss.cloudkitchen.data.responces.User
import com.kss.cloudkitchen.ui.model.SideNavItem
import com.kss.cloudkitchen.util.startNewActivity

class MainActivity : AppCompatActivity() {
    private var list: List<User> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}