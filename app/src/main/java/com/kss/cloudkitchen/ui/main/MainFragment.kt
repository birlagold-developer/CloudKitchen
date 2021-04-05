package com.kss.cloudkitchen.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.kss.cloudkitchen.R
import com.kss.cloudkitchen.data.network.AuthApi
import com.kss.cloudkitchen.data.repository.AuthRepository
import com.kss.cloudkitchen.databinding.FragmentMainBinding
import com.kss.cloudkitchen.ui.base.BaseFragment
import com.kss.cloudkitchen.ui.main.MainViewModel
import com.kss.cloudkitchen.ui.model.SideNavItem

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.e("MainFragmentViewCreated","called===>");
        binding.imHamburger.setOnClickListener {
            Log.e("setOnClickListener","called===>");
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }


    fun closeDrawer(item: SideNavItem) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        when (item.id) {
            1 -> {
                findNavController().navigate(R.id.addAddressFragment)
            }
        }
    }

    override fun getViewModel() = MainViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi(AuthApi::class.java),userPreferences)




}