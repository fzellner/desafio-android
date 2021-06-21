package com.picpay.desafio.android.repository

import androidx.room.withTransaction
import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.db.AppDb
import com.picpay.desafio.android.users.domain.exception.NullUsersException
import com.picpay.desafio.android.users.domain.model.User
import com.picpay.desafio.android.users.repository.UserRepository
import com.picpay.desafio.android.util.networkBoundResource
import com.picpay.desafio.android.util.safeAwait
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

@ExperimentalCoroutinesApi
class UsersRepositotyImpl(
    private val db: AppDb,
    private val picPayService: PicPayService,
) : UserRepository {

    override fun getAll(): Flow<List<User>> {
        return networkBoundResource(
            query = {
                db.users().getAll()
            },
            fetch = {
                picPayService.getUsers().safeAwait().toList()
            },
            saveFetchResult = { users ->
                users.map {
                    db.withTransaction {
                        db.users().insert(it ?: throw NullUsersException)
                    }
                }
            }
        ).map {
            it.data?.map { userDTO ->
                User(userDTO.id, userDTO.username, userDTO.name, userDTO.img)
            } ?: throw NullUsersException
        }
    }
}



