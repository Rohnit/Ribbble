package com.ronit.ribbble.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ronit on 9/4/18.
 */
class TokenResponse {

    @SerializedName("access_token")
    @Expose
    val token: String? = null

    @SerializedName("token_type")
    @Expose
    val tokenType: String? = null

    @SerializedName("created_at")
    @Expose
    val createdAt: Long? = null

}