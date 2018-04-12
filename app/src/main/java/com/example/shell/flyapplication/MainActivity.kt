package com.example.shell.flyapplication


import android.os.Bundle
import android.widget.Toolbar
import com.example.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadToolbar(toolbar as Toolbar)


    }
}
