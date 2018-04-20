package com.ronit.ribbble

import android.app.Application
import com.ronit.ribbble.di.component.ApplicationComponent
import com.ronit.ribbble.di.component.DaggerApplicationComponent
import com.ronit.ribbble.di.module.ApplicationModule
import com.ronit.ribbble.presentation.utils.unSafeLazy

/**
 * Created by ronit on 9/4/18.
 */
class App : Application() {

    val applicationComponent: ApplicationComponent by unSafeLazy {
        DaggerApplicationComponent.builder()
                //.applicationModule(ApplicationModule(this))
                .build()
    }

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

}