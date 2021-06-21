package com.picpay.desafio.android.users.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.users.R
import com.picpay.desafio.android.users.ui.adapter.UserListAdapter
import kotlinx.android.synthetic.main.users_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment() {
    private val viewModel: UsersViewModel by viewModel()
    private lateinit var usersAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater.inflate(R.layout.users_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        defineObservables()
    }

    private fun defineObservables() {
        viewModel.getUsers()
        viewModel.userState.observe(viewLifecycleOwner) { userState ->
            when (userState) {
                is UsersViewModel.UserViewState.LOADING -> {
                    showLoadingView()
                }
                is UsersViewModel.UserViewState.SUCCESS -> {
                    usersAdapter = UserListAdapter().apply { users = userState.userList }
                    hideLoadingView()
                    setAdapter()
                }
                is UsersViewModel.UserViewState.ERROR -> {
                    Toast.makeText(context,
                        getString(R.string.something_gone_wrong),
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun showLoadingView() {
        loading.visibility = View.VISIBLE
    }

    private fun hideLoadingView() {
        loading.visibility = View.GONE
    }

    private fun setAdapter() {
        usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }
    }

}