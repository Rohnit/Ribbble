package com.ronit.ribbble.presentation.screen.auth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.ronit.ribbble.R
import com.ronit.ribbble.presentation.base_mvp.base.BaseActivity
import javax.inject.Inject

class AuthActivity : BaseActivity<AuthContract.View, AuthContract.Presenter>(), AuthContract.View {

    @Inject
    protected lateinit var authPresenter: AuthPresenter

    override fun initPresenter(): AuthContract.Presenter = authPresenter

    override fun injectDependencies() {
        activityComponent.inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showError(message: String?) {

    }

    override fun startOAuthIntent(uri: Uri) {
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    override fun openHomeActivity() {

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        presenter.checkLogin(intent)
    }

}