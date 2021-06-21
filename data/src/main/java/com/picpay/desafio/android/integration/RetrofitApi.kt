package com.picpay.desafio.android.integration

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitApi {

    fun createNetworkClient(baseUrl: String, debug: Boolean = true) =
        retrofitClient(
            baseUrl,
            httpClient(debug)
        )

    private fun httpClient(debug: Boolean): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

        if (debug) {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }

        return clientBuilder
            .build()
    }




    private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}