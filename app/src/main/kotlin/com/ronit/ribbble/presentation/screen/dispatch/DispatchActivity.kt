package com.ronit.ribbble.presentation.screen.dispatch

import com.ronit.ribbble.presentation.base_mvp.base.BaseActivity
import com.ronit.ribbble.presentation.screen.auth.AuthActivity
import com.ronit.ribbble.presentation.utils.extentions.start
import javax.inject.Inject

class DispatchActivity : BaseActivity<DispatchContract.View, DispatchContract.Presenter>(), DispatchContract.View {

    @Inject
    protected lateinit var dispatchPresenter: DispatchPresenter


    override fun injectDependencies() {
        activityComponent.inject(this)
    }

    override fun initPresenter() = dispatchPresenter


    override fun openHomeActivity() {
        finish()
    }

    override fun openLoginActivity() {
        start<AuthActivity>()
        finish()
    }


}