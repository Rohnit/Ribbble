package com.ronit.ribbble.presentation.screen.auth

import android.content.Intent
import android.net.Uri
import com.ronit.ribbble.presentation.base_mvp.api.ApiContract

interface AuthContract {

    interface View : ApiContract.View {

        fun startOAuthIntent(uri: Uri)

        fun openHomeActivity()

    }

    interface Presenter : ApiContract.Presenter<View> {

        fun makeLogin()

        fun checkLogin(resultIntent: Intent?)

    }

}