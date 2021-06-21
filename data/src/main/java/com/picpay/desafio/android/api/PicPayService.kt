package com.picpay.desafio.android.api

import com.picpay.desafio.android.domain.model.UserDTO
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    fun getUsers(): Deferred<Response<List<UserDTO>?>>
}
