package com.picpay.desafio.android.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.domain.model.UserDTO

@Database(
    entities = [UserDTO::class],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory : Boolean): AppDb {
            val databaseBuilder = if(useInMemory) {
                Room.inMemoryDatabaseBuilder(context, AppDb::class.java)
            } else {
                Room.databaseBuilder(context, AppDb::class.java, "app.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun users() : UsersDao
}