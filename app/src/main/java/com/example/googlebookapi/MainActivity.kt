package com.example.googlebookapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebookapi.api.Item
import com.example.googlebookapi.myadapter.BookAdapter
import com.example.googlebookapi.retrofitwork.RetrofitHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.content.SharedPreferences


class MainActivity : AppCompatActivity() {
    lateinit var items: List<Item>
    lateinit var query : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_circular.visibility = View.GONE
        cancel_button.visibility = View.GONE

        val i = Intent(this,DatabaseROOM::class.java)
        buttonCart1.setOnClickListener(View.OnClickListener {
            this.startActivity(i)
        })


        button1.setOnClickListener(View.OnClickListener {
            progress_circular.visibility = View.VISIBLE
            button1.visibility = View.GONE
            cancel_button.visibility = View.VISIBLE
            query = editTextTextPersonName.text.toString()
            CoroutineScope(Dispatchers.Default).launch {
                val result = RetrofitHelper.getInstance().getBooks(query)
                val job1 = launch {
                    items = result.body()!!.items!!
                    Log.d("Bobby", result.body()!!.items?.get(0)?.kind.toString())
                }
                job1.join()

                val job2 = launch {
                    CoroutineScope(Dispatchers.Main).launch {
                        rView.layoutManager = LinearLayoutManager(this@MainActivity)
                        rView.adapter = BookAdapter(this@MainActivity, items)
                        progress_circular.visibility = View.GONE
                    }
                }
            }
        })

        cancel_button.setOnClickListener(View.OnClickListener {
            button1.visibility = View.VISIBLE
            cancel_button.visibility = View.GONE
            editTextTextPersonName.text.clear()
        })
    }
}