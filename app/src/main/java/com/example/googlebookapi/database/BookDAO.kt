package com.example.googlebookapi.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDAO {

    @Insert
    suspend fun insertBook(bookInfo: BookInfo)

    @Delete
    suspend fun deleteBook(bookInfo: BookInfo)

    @Query("SELECT * FROM books")
    fun getAllBooks() : LiveData<List<BookInfo>>

}