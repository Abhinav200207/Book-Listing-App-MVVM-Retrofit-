package com.example.googlebookapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.googlebookapi.apisingle.Info
import com.example.googlebookapi.database.BookInfo
import com.example.googlebookapi.mvvm.BookViewModel
import com.example.googlebookapi.retrofitwork.RetrofitHelper
import kotlinx.android.synthetic.main.activity_single_book.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList


class SingleBook : AppCompatActivity() {
    lateinit var idBook: String
    lateinit var info : Info
    lateinit var price : String
    lateinit var name : String
    lateinit var author : String
    lateinit var publishedDate : String
    lateinit var description : String
    lateinit var thumbnail : String
    lateinit var selfLink : String
    lateinit var buylink : String
    lateinit var pageCount : String
    lateinit var viewModel : BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_book)

        idBook = intent.getStringExtra("id").toString()
        author = intent.getStringExtra("author_name").toString()
        pageCount = intent.getStringExtra("page_count").toString()
        name = intent.getStringExtra("name").toString()
        publishedDate = intent.getStringExtra("publishedDate").toString()
        description = intent.getStringExtra("description").toString()
        selfLink = intent.getStringExtra("slfLink").toString()
        thumbnail = intent.getStringExtra("thumbnail").toString()
        price = intent.getStringExtra("price").toString()
        buylink = intent.getStringExtra("buyLink").toString()


        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(BookViewModel::class.java)

        updateUifunab()

        buttonCart.setOnClickListener(View.OnClickListener {
            viewModel.insert(BookInfo(name,author,publishedDate,pageCount,price,thumbnail,selfLink,buylink))
            val text = "Added Successfully"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        })

    }

    private fun updateUifunab() {
        textView7.text = "AUTHOR: $author"
        textView6.text = "TITLE: $name"
        textView8.text = "PUBLISHED DATE: $publishedDate"
        textView9.text = "PRICE $price/-"
        textView11.text = "DESCRIPTION OF BOOK: " + description
        Glide.with(this).load(thumbnail).into(imageView2)
    }
}