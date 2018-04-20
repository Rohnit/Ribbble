package com.ronit.ribbble.presentation.utils

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.ronit.ribbble.App

/**
 * Created by ronit on 9/4/18.
 */


infix fun Context.takeColor(colorId: Int) = ContextCompat.getColor(this, colorId)

operator fun Context.get(resId: Int): String = getString(resId)

operator fun Fragment.get(resId: Int): String = getString(resId)

@Experimental
fun Int.text(): String = App.instance.getString(this)

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

inline fun delay(milliSeconds: Long, crossinline action: () -> Unit) {
    Handler().postDelayed({
        action()
    }, milliSeconds)
}

val emptyString = ""

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
inline fun Lorabove(body: () -> Unit) {
    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
        body()
    }
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
inline fun MorAbove(body: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        body()
    }
}

@TargetApi(Build.VERSION_CODES.N)
inline fun NorAbove(body: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        body()
    }
}


fun <T> unSafeLazy(initializer: () -> T): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE) {
        initializer()
    }
}