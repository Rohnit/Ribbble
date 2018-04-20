package com.ronit.ribbble.data.network

import com.ronit.ribbble.data.pref.Preferences
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by ronit on 9/4/18.
 */
class TokenInterceptor constructor(private val preferences: Preferences) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val accessToken = if (preferences.isUserLoggedIn)
            preferences.token
        else
            ApiConstants.TOKEN

        val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $accessToken")
                .build()

        return chain.proceed(request)

    }


}