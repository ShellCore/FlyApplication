package com.example.shell.flyapplication.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.mylibrary.ToolbarActivity
import com.example.shell.flyapplication.R
import com.example.shell.flyapplication.ui.fragments.ArrivalsFragment
import com.example.shell.flyapplication.ui.fragments.DeparturesFragment
import com.example.shell.flyapplication.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadToolbar(toolbar as Toolbar)
        setNavDrawer()
        fragmentTransaction(HomeFragment())
        navView.menu.getItem(0).isChecked = true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> fragmentTransaction(HomeFragment())
            R.id.nav_arrivals -> fragmentTransaction(ArrivalsFragment())
            R.id.nav_departures -> fragmentTransaction(DeparturesFragment())
        }

        return true
    }

    private fun setNavDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, _toolbar, R.string.open_drawer, R.string.close_drawer)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    private fun fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }
}
