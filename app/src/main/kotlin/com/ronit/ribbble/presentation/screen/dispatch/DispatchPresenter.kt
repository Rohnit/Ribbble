package com.ronit.ribbble.presentation.screen.dispatch

import com.ronit.ribbble.di.scope.PerActivity
import com.ronit.ribbble.domain.interactor.UserInteractor
import com.ronit.ribbble.presentation.base_mvp.base.BasePresenter
import javax.inject.Inject

@PerActivity
class DispatchPresenter @Inject constructor(private val userInteractor: UserInteractor)
    : BasePresenter<DispatchContract.View>(), DispatchContract.Presenter {

    override fun onPresenterCreate() {
        super.onPresenterCreate()
        if (userInteractor.isUserLoggedIn()){
            view?.openHomeActivity()
        } else {
            view?.openLoginActivity()
        }
    }

}