package com.example.googlebookapi.mvvm

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.googlebookapi.database.BookDAO
import com.example.googlebookapi.database.BookInfo

class BookRepo(private val bookDAO: BookDAO) {
    val allBooks : LiveData<List<BookInfo>> = bookDAO.getAllBooks()

    @WorkerThread
    suspend fun insert(bookInfo: BookInfo){
        bookDAO.insertBook(bookInfo)
    }


    @WorkerThread
    suspend fun delete(bookInfo: BookInfo){
        bookDAO.deleteBook(bookInfo)
    }
}

//import androidx.annotation.WorkerThread
//import androidx.lifecycle.LiveData
//import com.example.googlebookapi.database.BookDAO
//import com.example.googlebookapi.database.BookInfo
//
//class BookRepo(private val bookDAO: BookDAO) {
//    val allbook : LiveData<List<BookInfo>> = bookDAO.getAllBooks()
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun insert(bookInfo: BookInfo){
//        bookDAO.insertBook(bookInfo)
//    }
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun delete(bookInfo: BookInfo){
//        bookDAO.deleteBook(bookInfo)
//    }
//
//}