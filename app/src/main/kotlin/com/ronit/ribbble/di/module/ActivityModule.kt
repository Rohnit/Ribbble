package com.ronit.ribbble.di.module

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import com.ronit.ribbble.di.scope.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by ronit on 9/4/18.
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @PerActivity
    @Provides
    fun providesActivity(): AppCompatActivity = activity

    @PerActivity
    @Provides
    fun providesLayoutInflator(activity: AppCompatActivity): LayoutInflater =
            LayoutInflater.from(activity)


    @PerActivity
    @Provides
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager =
            activity.supportFragmentManager

}