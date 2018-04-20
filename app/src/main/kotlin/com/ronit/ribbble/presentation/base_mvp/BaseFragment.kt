package com.ronit.ribbble.presentation.base_mvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronit.ribbble.R
import com.ronit.ribbble.di.component.ActivityComponent
import com.ronit.ribbble.presentation.base_mvp.base.BaseActivity
import com.ronit.ribbble.presentation.base_mvp.base.BaseContract
import com.ronit.ribbble.presentation.navigation.Navigator
import com.ronit.ribbble.presentation.utils.emptyString
import io.armcha.arch.BaseMVPFragment
import javax.inject.Inject

abstract class BaseFragment<V: BaseContract.View, P: BaseContract.Presenter<V>> : BaseMVPFragment<V, P>() {


    @Inject
    lateinit var navigator: Navigator

    protected lateinit var activityComponent: ActivityComponent
    protected lateinit var activity: BaseActivity<*, *>

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>){
            this.activity = context
            activityComponent = activity.activityComponent
            injectDependencies()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(layoutResId, container, false)
    }

    inline fun <reified T: Fragment> goTo(keepState: Boolean = true,
                                          withCustomAnimation: Boolean = false,
                                          arg: Bundle = Bundle.EMPTY) {
        navigator.goTo<T>(keepState = keepState, withCustomAnimation = withCustomAnimation, arg = arg)
    }


    protected abstract fun injectDependencies()

    protected abstract val layoutResId: Int


    open fun getTitle(): String = emptyString

    fun showDialog(title: String, message: String, buttonText: String = "Close") {
        activity.showDialog(title, message, buttonText)
    }

    fun showErrorDialog(message: String?, buttonText: String = "Close") {
        activity.showDialog(getString(R.string.error_title), message ?: emptyString, buttonText)
    }

}