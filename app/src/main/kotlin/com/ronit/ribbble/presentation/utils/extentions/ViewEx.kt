package com.ronit.ribbble.presentation.utils.extentions

import android.view.View


fun View.OnClick(function: () -> Unit) {

    setOnClickListener {
        function()
    }
}