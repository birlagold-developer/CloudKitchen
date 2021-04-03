package com.kss.cloudkitchen.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kss.cloudkitchen.R
import com.kss.cloudkitchen.ui.adapter.SideNavAdapter
import com.kss.cloudkitchen.ui.main.MainFragment
import com.kss.cloudkitchen.ui.model.SideNavItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_side_nav.*

class SideNavFragment : Fragment(){

    private val sideNavAdapter: SideNavAdapter = SideNavAdapter { position, item ->
        onItemClick(position,item)
    }

    private fun onItemClick(position: Int, item: SideNavItem) {
        Toast.makeText(requireContext(),""+item.itemName,Toast.LENGTH_LONG).show()
        (requireParentFragment() as MainFragment).closeDrawer(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_side_nav, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        rv_side_nav_options?.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rv_side_nav_options?.adapter = sideNavAdapter
        sideNavAdapter.setNavItemsData(prrepareNavItems())
    }

    //Create List of items to be displayed on the sidenav
    private fun prrepareNavItems(): List<SideNavItem> {
        val menuItemsList = ArrayList<SideNavItem>()
        menuItemsList.add(SideNavItem(1,"Upgrade",R.drawable.ic_round_location))
        menuItemsList.add(SideNavItem(2,"Rate us",R.drawable.ic_round_location))
        menuItemsList.add(SideNavItem(3,"Share",R.drawable.ic_round_location))
        menuItemsList.add(SideNavItem(5,"Settings",R.drawable.ic_round_location))
        return menuItemsList
    }
}