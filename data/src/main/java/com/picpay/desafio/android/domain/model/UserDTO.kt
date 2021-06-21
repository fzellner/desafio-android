package com.picpay.desafio.android.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(
    tableName = "users"
)
data class UserDTO(
    @SerializedName("img") val img: String,
    @SerializedName( "name") val name: String,
    @PrimaryKey
    @SerializedName( "id") val id: Long,
    @SerializedName("username") val username: String,
)