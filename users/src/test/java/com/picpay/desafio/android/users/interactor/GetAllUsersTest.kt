package com.picpay.desafio.android.users.interactor

import com.picpay.desafio.android.model.UseCase
import com.picpay.desafio.android.users.domain.model.User
import com.picpay.desafio.android.users.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test

class GetAllUsersTest {

    companion object {
        val users = listOf(
            User(0, "username_0", "Name 0", ""),
            User(1, "username_0", "Name 0", ""),
            User(2, "username_0", "Name 0", ""),
            User(3, "username_0", "Name 0", ""),
        )

    }

    @MockK
    lateinit var repository: UserRepository

    lateinit var useCase: GetAllUsers

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = GetAllUsers(repository)

        coEvery {
            repository.getAll()
        } returns flow {
            emit(users)
        }
    }

    @Test
    fun `usecase should call repository`() {
        useCase(UseCase.None)
        coVerify {
            repository.getAll()
        }
    }


}