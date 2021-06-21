package com.picpay.desafio.android.di

import android.content.ContentResolver
import com.picpay.desafio.android.users.di.UsersInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object AppInject {

    private val appModules = module {
        single<ContentResolver> { androidContext().contentResolver }
        single { Executors.newSingleThreadExecutor() as Executor }
    }

    fun modules(): List<Module> =
        ArrayList<Module>().apply {
            add(appModules)
            addAll(DataInject.modules)
            addAll(UsersInject.modules())

        }

}
