package com.ronit.ribbble.di.module

import com.ronit.ribbble.BuildConfig
import com.ronit.ribbble.data.network.*
import com.ronit.ribbble.data.pref.Preferences
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by ronit on 9/4/18.
 */
@Module
class ApiModule {


    @Singleton
    @Provides
    @Named("shotEndpoint")
    fun shotEndpoint() = ApiConstants.SHOT_ENDPOINT

    @Singleton
    @Provides
    @Named("authEndpoint")
    fun authEndpoint() = ApiConstants.AUTH_ENDPOINT

    @Singleton
    @Provides
    fun interceptor(preferences: Preferences) = TokenInterceptor(preferences)

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG){
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC
            okHttpBuilder.addInterceptor(logging)
        }
        return okHttpBuilder.apply {
            readTimeout(15.toLong(), TimeUnit.SECONDS)
            connectTimeout(15.toLong(), TimeUnit.SECONDS)
        }
    }


    @Singleton
    @Provides
    @Named("shotRetrofit")
    fun provideShotRetrofit(retrofitBuilder: Retrofit.Builder,
                            okHttpClientBuilder: OkHttpClient.Builder,
                            interceptor: TokenInterceptor,
                            @Named("shotEndpoint") baseUrl: String): Retrofit {
        val client = okHttpClientBuilder.addInterceptor(interceptor).build()
        return retrofitBuilder
                .client(client)
                .baseUrl(baseUrl)
                .build()
    }


    @Singleton
    @Provides
    @Named("authRetrofit")
    fun provideAuthRetrofit(retrofitBuilder: Retrofit.Builder,
                            okHttpClientBuilder: OkHttpClient.Builder,
                            @Named("authEndpoint") baseUrl: String): Retrofit {

        return retrofitBuilder
                .client(okHttpClientBuilder.build())
                .baseUrl(baseUrl)
                .build()
    }


    @Singleton
    @Provides
    fun provideRetrofitBuilder():Retrofit.Builder {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }


    @Singleton
    @Provides
    fun provideShotApiService(@Named("shotRetrofit") retrofit: Retrofit): ShotApiService {
        return retrofit.create(ShotApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideUserApiService(@Named("shotRetrofit") retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideAuthApiService(@Named("authRetrofit") retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

}