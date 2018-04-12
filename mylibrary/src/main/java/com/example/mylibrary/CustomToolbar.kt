package com.example.mylibrary

import android.widget.Toolbar

interface CustomToolbar {
    fun loadToolbar(toolbar: Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}