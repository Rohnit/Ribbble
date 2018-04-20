package com.ronit.ribbble.di.component

import com.ronit.ribbble.di.module.ActivityModule
import com.ronit.ribbble.di.module.ApiModule
import com.ronit.ribbble.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ronit on 9/4/18.
 */
@Singleton
@Component(modules = [(ApplicationModule::class), (ApiModule::class)])
interface ApplicationComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent

}