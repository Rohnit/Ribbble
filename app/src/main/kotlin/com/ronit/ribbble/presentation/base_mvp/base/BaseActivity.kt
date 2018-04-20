package com.ronit.ribbble.presentation.base_mvp.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import com.ronit.ribbble.App
import com.ronit.ribbble.di.component.ActivityComponent
import com.ronit.ribbble.di.module.ActivityModule
import com.ronit.ribbble.presentation.utils.unSafeLazy
import io.armcha.arch.BaseMVPActivity
import javax.inject.Inject

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : BaseMVPActivity<V, P>() {


    @Inject
    lateinit var inflater: LayoutInflater

    val activityComponent: ActivityComponent by unSafeLazy {
        getAppComponent() + ActivityModule(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }


    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }


    protected abstract fun injectDependencies()


    private fun getAppComponent() = App.instance.applicationComponent


    inline protected fun <reified T : Fragment> goTo(keepState : Boolean = true,
                                                     withCustomAnimation: Boolean = false,
                                                     arg: Bundle = Bundle.EMPTY) {

    }

    fun showDialog(title: String, message: String, buttonText: String = "Close"){

    }

    fun showErrorDialog(message: String?, buttonText: String = "Close"){

    }

}