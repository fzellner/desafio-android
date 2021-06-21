package com.picpay.desafio.android.users.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.model.UseCase
import com.picpay.desafio.android.users.domain.model.User
import com.picpay.desafio.android.users.interactor.GetAllUsers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class UsersViewModel(private val getAllUsers: GetAllUsers) : ViewModel() {

    val userState = MutableLiveData<UserViewState>()

    fun getUsers(){
        getAllUsers(UseCase.None)
            .onStart { userState.value = UserViewState.LOADING }
            .onEach {
                userState.value = UserViewState.SUCCESS(it)
            }
            .catch {
                userState.value = UserViewState.ERROR
            }
            .launchIn(viewModelScope)
    }

    sealed class UserViewState {
        object LOADING : UserViewState()
        object ERROR : UserViewState()
        data class SUCCESS(val userList: List<User>) : UserViewState()
    }


}