package com.sakibssamad.tab_demo.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity, fragmentList: ArrayList<Fragment>) :
    FragmentStateAdapter(fragmentActivity){

      var fragmentList1: ArrayList<Fragment> = ArrayList()

    init {
        fragmentList1 = fragmentList
    }
    override fun getItemCount(): Int {
        return fragmentList1.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            position -> fragmentList1[position]
            else -> fragmentList1[0]
        }
    }
}