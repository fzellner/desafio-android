package com.picpay.desafio.android.users.di

import com.picpay.desafio.android.users.interactor.GetAllUsers
import com.picpay.desafio.android.users.ui.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object UsersInject {


    private val viewModelModule: Module = module {
        viewModel { UsersViewModel(get()) }
    }

    private val useCaseModule: Module = module {
        factory { GetAllUsers(get()) }
    }

    fun modules(): List<Module> = listOf(viewModelModule, useCaseModule)


}