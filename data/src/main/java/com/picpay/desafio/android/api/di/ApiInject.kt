package com.picpay.desafio.android.api.di

import com.picpay.desafio.android.BuildConfig
import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.integration.RetrofitApi
import org.koin.core.module.Module
import org.koin.dsl.module

object ApiInject {

    fun module(): Module = module {
        single {
            RetrofitApi.createNetworkClient(BuildConfig.BASE_URL).create(PicPayService::class.java)
        }
    }
}