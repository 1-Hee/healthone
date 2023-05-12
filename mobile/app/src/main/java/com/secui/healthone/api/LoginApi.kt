package com.secui.healthone.api

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface LoginApi {
    @POST("authserver/authlogin")
    suspend fun sendAuthCodeToServer(@Body authCode: RequestBody): Response<ResponseBody>

    @POST("auth/verify")
    suspend fun verifyAuth(@Header("Authorization") authHeader: String): Response<ResponseBody>
}