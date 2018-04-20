package com.ronit.ribbble.presentation.screen.dispatch

import com.ronit.ribbble.presentation.base_mvp.base.BaseContract

interface DispatchContract {

    interface View : BaseContract.View {

        fun openHomeActivity()

        fun openLoginActivity()

    }


    interface Presenter : BaseContract.Presenter<View>

}