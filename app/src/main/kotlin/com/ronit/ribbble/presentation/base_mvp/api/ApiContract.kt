package com.ronit.ribbble.presentation.base_mvp.api

import com.ronit.ribbble.presentation.base_mvp.base.BaseContract

interface ApiContract {


    interface View : BaseContract.View {

        fun showLoading() {}

        fun hideLoading() {}

        fun showError(message : String?) {}

    }

    interface Presenter<V : BaseContract.View> : BaseContract.Presenter<V>

}