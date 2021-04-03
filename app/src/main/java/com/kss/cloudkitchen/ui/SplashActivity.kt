package com.kss.cloudkitchen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.kss.cloudkitchen.R
import com.kss.cloudkitchen.data.preferences.UserPreferences
import com.kss.cloudkitchen.ui.main.MainActivity
import com.kss.cloudkitchen.ui.ordertype.OrderTypeActivity
import com.kss.cloudkitchen.util.startNewActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val userPreferences = UserPreferences(this)
        userPreferences.authToken.asLiveData().observe(this, Observer {
            val activity = if(it != null) OrderTypeActivity::class.java else MainActivity::class.java
            startNewActivity(activity)

        })
    }
}