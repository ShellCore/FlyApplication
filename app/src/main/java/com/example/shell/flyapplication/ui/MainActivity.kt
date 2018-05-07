package com.example.shell.flyapplication.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import com.example.mylibrary.ToolbarActivity
import com.example.shell.flyapplication.R
import com.example.shell.flyapplication.ui.fragments.ArrivalsFragment
import com.example.shell.flyapplication.ui.fragments.DeparturesFragment
import com.example.shell.flyapplication.ui.fragments.HomeFragment
import com.example.shell.flyapplication.utils.showMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadToolbar(toolbar as Toolbar)
        setNavDrawer()
        fragmentTransaction(HomeFragment())
        navView.menu.getItem(0).isChecked = true
        setUserHeaderInformation()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        loadFragmentById(item.itemId)
        showMessageNavItemSelectedById(item.itemId)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
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

    private fun loadFragmentById(id: Int) {
        when(id) {
            R.id.nav_home -> fragmentTransaction(HomeFragment())
            R.id.nav_arrivals -> fragmentTransaction(ArrivalsFragment())
            R.id.nav_departures -> fragmentTransaction(DeparturesFragment())
        }
    }

    private fun showMessageNavItemSelectedById(id: Int) {
        when(id) {
            R.id.nav_profile -> showMessage("Profile")
            R.id.nav_settings -> showMessage("Settings")
        }
    }

    private fun setUserHeaderInformation() {
        val name = navView.getHeaderView(0)
                .findViewById<TextView>(R.id.txtTitleName)
        val email = navView.getHeaderView(0)
                .findViewById<TextView>(R.id.txtTitleEmail)

        name?.let {
            name.text = getString(R.string.user_name)
        }
        email?.let {
            email.text = getString(R.string.user_email)
        }

    }

    private fun showMessage(message: String) = container.showMessage(message)
}
