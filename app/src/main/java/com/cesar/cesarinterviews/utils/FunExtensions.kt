package com.cesar.cesarinterviews.utils

import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

fun Context.inflateCustomView(layout: Int, viewGroup: ViewGroup?) {
    val inflater= this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    inflater.inflate(layout, viewGroup, true)
}
