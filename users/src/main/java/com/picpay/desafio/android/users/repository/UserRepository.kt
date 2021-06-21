package com.picpay.desafio.android.users.repository

import com.picpay.desafio.android.users.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAll(): Flow<List<User>>
}