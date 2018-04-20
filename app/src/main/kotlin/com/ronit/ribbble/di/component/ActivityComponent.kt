package com.ronit.ribbble.di.component

import com.ronit.ribbble.di.module.ActivityModule
import com.ronit.ribbble.di.scope.PerActivity
import com.ronit.ribbble.presentation.screen.auth.AuthActivity
import com.ronit.ribbble.presentation.screen.dispatch.DispatchActivity
import dagger.Subcomponent

/**
 * Created by ronit on 9/4/18.
 */
@PerActivity
@Subcomponent(modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(authActivity: AuthActivity)

    fun inject(dispatchActivity: DispatchActivity)

}