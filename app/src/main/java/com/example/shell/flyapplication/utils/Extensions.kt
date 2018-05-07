package com.example.shell.flyapplication.utils

import android.app.Activity
import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.showMessage(message: String, duration: Int = Snackbar.LENGTH_SHORT) = Snackbar.make(this, message, duration).show()

fun ViewGroup.inflate(resource: Int): View = LayoutInflater.from(context).inflate(resource, this, false)

fun ImageView.loadByUrl(url: String) = Picasso.get().load(url).into(this)

fun ImageView.loadByResource(resource: Int) = Picasso.get().load(resource).fit().into(this)

inline fun <reified T : Activity> Activity.goToActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}