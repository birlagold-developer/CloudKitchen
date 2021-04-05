package com.kss.cloudkitchen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kss.cloudkitchen.R
import com.kss.cloudkitchen.ui.model.SideNavItem
import kotlinx.android.synthetic.main.item_side_nav.view.*

class SideNavAdapter(private val onItemClick: ((position: Int, item: SideNavItem) -> Unit)) :
    RecyclerView.Adapter<SideNavAdapter.SideNavVH>() {
    var menuItemsList = ArrayList<SideNavItem>()

    fun setNavItemsData( list: List<SideNavItem>){
        menuItemsList.clear()
        menuItemsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SideNavAdapter.SideNavVH {
        return SideNavVH(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_side_nav, viewGroup, false)
        )
    }

    inner class SideNavVH(inflate: View) : RecyclerView.ViewHolder(inflate) {
        fun setData(sideNavItem: SideNavItem) {
            itemView.setOnClickListener {
                sideNavItem.let {
                    onItemClick.invoke(adapterPosition, sideNavItem)
                }
            }
            itemView.iv_nav_option?.setImageResource(sideNavItem.resourceId)
            itemView.tv_nav_text?.text = sideNavItem.itemName
        }
    }

    override fun getItemCount(): Int {
        return menuItemsList.size
    }

    override fun onBindViewHolder(holder: SideNavVH, position: Int) {
        holder.setData(menuItemsList[position])
    }
}
