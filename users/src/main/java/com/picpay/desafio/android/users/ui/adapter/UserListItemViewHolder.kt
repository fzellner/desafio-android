package com.picpay.desafio.android.users.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.users.R
import com.picpay.desafio.android.users.domain.model.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User) {
        itemView.username.text = user.userName
        itemView.name.text = user.name
        Picasso.get()
            .load(user.picture)
            .error(R.drawable.ic_round_account_circle)
            .into(itemView.picture, object : Callback {
                override fun onSuccess() {
                  //  itemView.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                   // itemView.progressBar.visibility = View.GONE
                }
            })
    }
}