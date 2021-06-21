package com.picpay.desafio.android.users.interactor

import com.picpay.desafio.android.users.domain.model.User
import com.picpay.desafio.android.users.repository.UserRepository
import com.picpay.desafio.android.model.UseCase
import kotlinx.coroutines.flow.Flow

class GetAllUsers(private val repository: UserRepository) :
    UseCase<List<User>, UseCase.None>() {

    override fun run(params: None): Flow<List<User>> =
        repository.getAll()

}