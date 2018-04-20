package com.ronit.ribbble.presentation.navigation

import io.reactivex.annotations.Experimental

@Experimental
sealed class BackStrategy {

    object KEEP : BackStrategy()
    object DESTROY : BackStrategy()

}