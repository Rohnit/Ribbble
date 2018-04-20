package com.ronit.ribbble.di.module

import android.app.Application
import com.ronit.ribbble.data.mapper.Mapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ronit on 9/4/18.
 */
@Module
class ApplicationModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Singleton
    @Provides
    fun provideMapper(): Mapper = Mapper()

}