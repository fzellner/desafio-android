package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.AppInject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class PicPayDesafioApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PicPayDesafioApplication)
            modules(AppInject.modules())
        }
    }
}