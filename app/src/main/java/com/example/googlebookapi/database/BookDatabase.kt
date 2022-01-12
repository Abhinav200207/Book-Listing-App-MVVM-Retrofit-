package com.example.googlebookapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookInfo::class],version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDAO

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase {
            return BookDatabase.INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "bookDB"
                ).build()
                BookDatabase.INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
