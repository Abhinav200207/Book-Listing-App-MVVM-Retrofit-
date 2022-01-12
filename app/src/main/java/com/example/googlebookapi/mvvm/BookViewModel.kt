package com.example.googlebookapi.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.googlebookapi.database.BookDatabase
import com.example.googlebookapi.database.BookInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application){

    val repository : BookRepo
    val allBooks : LiveData<List<BookInfo>>

    init {
        val dao = BookDatabase.getDatabase(application).bookDao()
        repository = BookRepo(dao)
        allBooks = repository.allBooks
    }

    fun delete(bookInfo: BookInfo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(bookInfo)
    }

    fun insert(bookInfo : BookInfo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(bookInfo)
    }
}

//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import com.example.googlebookapi.database.BookInfo
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class BookViewModel(private val bookRepo: BookRepo) : ViewModel() {
//    val allBooks : LiveData<List<BookInfo>> = bookRepo.allbook
//    fun insert(bookInfo: BookInfo) = CoroutineScope(Dispatchers.IO).launch {
//        bookRepo.insert(bookInfo)
//    }
//
//    fun delete(bookInfo: BookInfo) = CoroutineScope(Dispatchers.IO).launch {
//        bookRepo.delete(bookInfo)
//    }
//
//}