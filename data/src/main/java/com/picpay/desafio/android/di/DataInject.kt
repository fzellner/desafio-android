package com.picpay.desafio.android.di

import com.picpay.desafio.android.api.di.ApiInject
import com.picpay.desafio.android.db.AppDb
import com.picpay.desafio.android.repository.UsersRepositotyImpl
import com.picpay.desafio.android.users.repository.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module

object DataInject {

    private val dbModule = module {
        single { AppDb.create(get(), false) }
    }
    private val repositoryModule = module {
        single<UserRepository> { UsersRepositotyImpl(get(), get()) }
    }

    val modules: List<Module> = listOf(dbModule, repositoryModule, ApiInject.module())

}