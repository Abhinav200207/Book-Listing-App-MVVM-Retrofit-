package com.example.googlebookapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebookapi.database.BookInfo
import com.example.googlebookapi.mvvm.BookViewModel
import com.example.googlebookapi.myadapter.BookAdapterDb
import com.example.googlebookapi.myadapter.INotesRVAdapter

class DatabaseROOM : AppCompatActivity(), INotesRVAdapter{

    lateinit var viewModel : BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_room)

        val recyclerView = findViewById<RecyclerView>(R.id.rView1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = BookAdapterDb(this,this)
        recyclerView.adapter = adapter


        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(BookViewModel::class.java)
        viewModel.allBooks.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onItemClicked(book : BookInfo) {
        viewModel.delete(book)
        Toast.makeText(this,"Book Removed from cart", Toast.LENGTH_SHORT).show()
    }
}


