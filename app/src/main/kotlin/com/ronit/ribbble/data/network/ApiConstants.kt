package com.ronit.ribbble.data.network

import com.ronit.ribbble.BuildConfig

/**
 * Created by ronit on 9/4/18.
 */
object ApiConstants {

    const val TYPE_POPULAR = "views"

    const val TYPE_RECENT = "recent"

    const val SHOT_ENDPOINT = "https://api.dribbble.com/v1/"

    const val AUTH_ENDPOINT = "https://dribbble.com/oauth/"

    const val TOKEN = BuildConfig.DRIBBBLE_CLIENT_ACCESS_TOKEN

    const val CLIENT_ID = BuildConfig.DRIBBBLE_CLIENT_ID

    const val CLIENT_SECRET = BuildConfig.DRIBBBLE_CLIENT_SECRET

    const val LOGIN_OAUTH_URL = "${AUTH_ENDPOINT}authorize?client_id=$CLIENT_ID&redirect_uri=" +
            "ribbble%3A%2F%2Fdribbble-auth-callback&scope=public+write+comment+upload"

}