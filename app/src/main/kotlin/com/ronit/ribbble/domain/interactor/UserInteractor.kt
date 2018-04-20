package com.ronit.ribbble.domain.interactor

import com.ronit.ribbble.di.scope.PerActivity
import com.ronit.ribbble.domain.repository.UserRepository
import javax.inject.Inject

@PerActivity
class UserInteractor @Inject constructor(private val userDataRepository: UserRepository) {


    fun logout(){
        clearCache()
        userDataRepository.clearLoginData()
    }

    fun clearCache(){
        userDataRepository.clearCache()
    }



    fun isUserLoggedIn(): Boolean = userDataRepository.isUserLoggedIn()





    fun follow(userName: String) = userDataRepository.follow(userName)

}