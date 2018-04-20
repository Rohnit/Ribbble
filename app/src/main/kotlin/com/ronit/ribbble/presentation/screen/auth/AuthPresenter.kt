package com.ronit.ribbble.presentation.screen.auth

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.net.Uri
import com.ronit.ribbble.data.network.ApiConstants
import com.ronit.ribbble.di.scope.PerActivity
import com.ronit.ribbble.domain.interactor.UserInteractor
import com.ronit.ribbble.presentation.base_mvp.api.ApiPresenter
import javax.inject.Inject

@PerActivity
class AuthPresenter @Inject constructor(private val userInteractor: UserInteractor)
    : ApiPresenter<AuthContract.View>(), AuthContract.Presenter {

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    fun start(){
        if (AUTH statusIs SUCCESS)
            view?.showLoading()
    }


    override fun makeLogin() {
        view?.startOAuthIntent(Uri.parse(ApiConstants.LOGIN_OAUTH_URL))
    }

    override fun checkLogin(resultIntent: Intent?) {
        val userCode: String? = resultIntent?.data?.getQueryParameter("code")
        userCode?.let {
            /*fetch(userInteractor.getUser(it), AUTH) {
                view?.hideLoading()
                view?.openHomeActivity()
            }*/
        }
    }

    override fun onRequestStart() {
        view?.showLoading()
    }

    override fun onRequestError(errorMessage: String?) {
        view?.apply {
            hideLoading()
            showError(errorMessage)
        }
    }


}