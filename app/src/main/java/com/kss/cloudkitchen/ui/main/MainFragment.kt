package com.kss.cloudkitchen.ui.main

import android.os.Bundle
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

        binding.imHamburger.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        /*binding.buttonSignin.enable(false)
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressbar.visible(it is Resource.loading)

            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        viewModel.saveAuthToken(it.value.user.access_token)
                        requireActivity().startNewActivity(HomeActivity::class.java)
                    }
                }
                is Resource.Failure -> handleApiError(it){login()}
            }
        })

        binding.eidttextPassword.addTextChangedListener {
            val email = binding.eidttextEmail.text.toString().trim()
            binding.buttonSignin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }



        binding.buttonSignin.setOnClickListener {
            login()
        }

        binding.buttonSignup.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }*/


    }

    /*private fun login(){
        val email = binding.eidttextEmail.text.toString().trim()
        val password = binding.eidttextPassword.text.toString().trim()
        viewModel.login(email, password)
    }*/

    fun closeDrawer(item: SideNavItem) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        when (item.id) {
            1 -> {
                findNavController().navigate(R.id.orderFragment)
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