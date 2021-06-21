package com.picpay.desafio.android.users.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.model.UseCase
import com.picpay.desafio.android.users.domain.model.User
import com.picpay.desafio.android.users.interactor.GetAllUsers
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UsersViewModelTest {

    companion object {
        const val UI_THREAD = "UI THREAD"
        val users = listOf(
            User(0, "username_0", "Name 0", ""),
            User(1, "username_0", "Name 0", ""),
            User(2, "username_0", "Name 0", ""),
            User(3, "username_0", "Name 0", ""),
        )

    }

    lateinit var viewModel: UsersViewModel

    @MockK
    private lateinit var useCase: GetAllUsers

    private val mainThreadSurrogate = newSingleThreadContext(UI_THREAD)

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        MockKAnnotations.init(this)
        viewModel = UsersViewModel(useCase)


    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `get should call usecase`() {
        coEvery {
            useCase(UseCase.None)
        } returns flow {
            emit(users)
        }
        viewModel.getUsers()
        coVerify {
            useCase(UseCase.None)
        }
    }

    @Test
    fun `viewModel should update viewState to LoadingState`() {
        viewModel.userState.value = UsersViewModel.UserViewState.LOADING
        viewModel.userState.observeForever{
            assert(it is UsersViewModel.UserViewState.LOADING)
        }
    }

    @Test
    fun `viewModel should update viewState to ErrorState`() {
        viewModel.userState.value = UsersViewModel.UserViewState.ERROR
        viewModel.userState.observeForever{
            assert(it is UsersViewModel.UserViewState.ERROR)
        }
    }

    @Test
    fun `viewModel should update viewState to SuccessState`() {
        viewModel.userState.value = UsersViewModel.UserViewState.SUCCESS(users)
        viewModel.userState.observeForever{
            assert(it is UsersViewModel.UserViewState.SUCCESS)
        }
    }


}