package com.ronit.ribbble.domain.repository

import io.reactivex.Completable

interface UserRepository {

    fun login()

    fun isUserLoggedIn(): Boolean

    fun follow(userName: String): Completable

    fun clearCache()

    fun clearLoginData()

    fun saveToken(token: String?)

}