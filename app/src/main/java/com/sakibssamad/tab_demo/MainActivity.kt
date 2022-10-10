package com.sakibssamad.tab_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sakibssamad.tab_demo.fragment.Tab1
import com.sakibssamad.tab_demo.fragment.Tab2
import com.sakibssamad.tab_demo.fragment.Tab3
import com.sakibssamad.tab_demo.fragment.Tab4
import com.sakibssamad.tab_demo.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var tab_toolbar: Toolbar
    lateinit var tab_viewpager: ViewPager2
    lateinit var tab_tablayout: TabLayout

    var tabNameList = listOf<String> ("Tab 1","Tab 2", "Tab 3","Tab 4")
    var fragmentList = arrayListOf<Fragment> (Tab1(),Tab2(), Tab3(),Tab4())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_toolbar = findViewById(R.id.toolbar)
        tab_viewpager = findViewById(R.id.tab_viewpager)
        tab_tablayout = findViewById(R.id.tab_tablayout)

        setSupportActionBar(tab_toolbar)

        setupViewPager()
        setupTabLayout()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(
            tab_tablayout, tab_viewpager
        ) { tab, position ->
            tab.text = tabNameList[position]
        }.attach()
    }

    private fun setupViewPager() {
        var adapter = ViewPagerAdapter(this,fragmentList)

        // setting adapter to view pager.
        tab_viewpager.setAdapter(adapter)
    }

    override fun onBackPressed() {
        val viewPager = tab_viewpager
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }


}