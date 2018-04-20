package com.ronit.ribbble.presentation.utils.extentions

import android.content.res.Configuration
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

/*inline infix fun <reified T> Fragment.extraWithKey(key: String): T {
    val value: Any = arguments[key]
    return value as T
}*/

fun Fragment.isPortrait() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

//infix fun Fragment.takeColor(colorId: Int) = ContextCompat.getColor(context, colorId)
