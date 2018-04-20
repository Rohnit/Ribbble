package com.ronit.ribbble.data.network

import com.ronit.ribbble.data.response.TokenResponse
import io.reactivex.Flowable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by ronit on 9/4/18.
 */
interface AuthApiService {

    @POST("token")
    fun getToken(@Query("code") authCode: String,
                 @Query("client_id") clientId: String = ApiConstants.CLIENT_ID,
                 @Query("client_secret") clientSecret: String = ApiConstants.CLIENT_SECRET): Flowable<TokenResponse>

}