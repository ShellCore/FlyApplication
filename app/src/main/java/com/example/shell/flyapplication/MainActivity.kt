package com.example.shell.flyapplication


import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadToolbar(toolbar as Toolbar)
        setNavDrawer()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

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
}
