package com.ronit.ribbble.presentation.base_mvp.base

import io.armcha.arch.BaseMVPContract

interface BaseContract {

    interface View : BaseMVPContract.View

    interface Presenter<V : BaseMVPContract.View> : BaseMVPContract.Presenter<V>

}