package com.ronit.ribbble.data.pref

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.ronit.ribbble.data.network.ApiConstants
import com.ronit.ribbble.presentation.utils.emptyString
import com.ronit.ribbble.presentation.utils.unSafeLazy
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ronit on 9/4/18.
 */
@Singleton
class Preferences @Inject constructor(app: Application) {


    private val SHARED_PREF_NAME = "ribbble_shared_pref"
    private val USER_LOGGED_IN = "user_logged_in"
    private val USER_TOKEN = "user_token"

    private val sharedPreferences by unSafeLazy {
        app.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    val isUserLoggedIn
        get() = sharedPreferences.getBoolean(USER_LOGGED_IN, false)
    val token: String
        get() = sharedPreferences.getString(USER_TOKEN, ApiConstants.TOKEN)

    fun saveUserLoggedIn() {
        sharedPreferences.put {
            putBoolean(USER_LOGGED_IN, true)
        }
    }

    fun saveUserLoggedOut() {
        sharedPreferences.put {
            putBoolean(USER_LOGGED_IN, false)
        }
    }

    infix fun saveUserToken(token: String?) {
        sharedPreferences.put {
            putString(USER_TOKEN, token)
        }
    }


    fun deleteToken() {
        sharedPreferences.put {
            putString(USER_TOKEN, emptyString)
        }
    }

}


private inline fun SharedPreferences.put(body: SharedPreferences.Editor.() -> Unit) {
    val editor = this.edit()
    editor.body()
    editor.apply()
}