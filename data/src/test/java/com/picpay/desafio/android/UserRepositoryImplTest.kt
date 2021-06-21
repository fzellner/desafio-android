package com.picpay.desafio.android

import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.db.AppDb
import com.picpay.desafio.android.domain.model.UserDTO
import com.picpay.desafio.android.repository.UsersRepositotyImpl
import com.picpay.desafio.android.users.domain.model.User
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    @MockK
    lateinit var service: PicPayService

    @MockK
    lateinit var appDb: AppDb

    private lateinit var repository: UsersRepositotyImpl


    companion object {
        val userDto = mutableListOf(UserDTO("", "default", 0, "default_user"))
        val user = User(0, "default_user", "default", "")
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = UsersRepositotyImpl(appDb, service)

    }

    @Test
    fun `repository should persist remote data in db`() = runBlockingTest {

        coEvery {
            appDb.users().getAll()
        } returns flow {
            emit(userDto)
        }

        coEvery {
            appDb.users().insert(userDto)
        } coAnswers {
            Any()
        }


        appDb.users().insert(userDto)
        val userFromDb = appDb.users().getAll()

        userFromDb.map { usersDto ->
            usersDto.map {
                assert(it.username == user.userName)
            }

        }
    }

    @Test
    fun `get should emit user list`() = runBlockingTest {

        coEvery {
            appDb.users().getAll()
        } returns flow {
            emit(userDto)
        }
        repository.getAll().collect {
            assert(it.isNotEmpty())

        }
    }


}


