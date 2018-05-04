package com.example.shell.flyapplication.ui.utils

import android.support.design.widget.Snackbar
import android.view.View

fun View.showMessage(message: String, duration: Int = Snackbar.LENGTH_SHORT) = Snackbar.make(this, message, duration).show()