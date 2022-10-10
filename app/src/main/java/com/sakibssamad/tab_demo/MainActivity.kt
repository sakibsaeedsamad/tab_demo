package com.sakibssamad.tab_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sakibssamad.tab_demo.fragment.Tab1
import com.sakibssamad.tab_demo.fragment.Tab2
import com.sakibssamad.tab_demo.fragment.Tab3
import com.sakibssamad.tab_demo.fragment.Tab4
import com.sakibssamad.tab_demo.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        var tab_viewpager = findViewById<ViewPager>(R.id.tab_viewpager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(tab_toolbar)
        setupViewPager(tab_viewpager)

        tab_tablayout.setupWithViewPager(tab_viewpager)
    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        //add fragment to adapter
        adapter.addFragment(Tab2(), "Tab2")
        adapter.addFragment(Tab4(), "Tab4")
        adapter.addFragment(Tab1(), "Tab1")
        adapter.addFragment(Tab3(), "Tab3")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }


}