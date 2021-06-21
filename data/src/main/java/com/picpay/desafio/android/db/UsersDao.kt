package com.picpay.desafio.android.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.domain.model.UserDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    fun getAll(): Flow<List<UserDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<UserDTO>)

}