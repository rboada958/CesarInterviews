package com.cesar.cesarinterviews.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.cesar.cesarinterviews.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class CesarToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppBarLayout(context, attrs, defStyleAttr) {

    var selectedMenuItem: MenuItem? = null
        private set

    private val innerToolbar: MaterialToolbar
    private val backButtonDrawable: Drawable?

    init {
        context.inflateCustomView(R.layout.cesar_toolbar, this)
        innerToolbar = rootView.findViewById(R.id.inner_toolbar)
        backButtonDrawable = ContextCompat.getDrawable(context, R.drawable.ic_arrow_back)

        val menu = innerToolbar.menu
        val menuItem = menu.findItem(R.id.search_item)
        selectedMenuItem = menuItem
    }
}