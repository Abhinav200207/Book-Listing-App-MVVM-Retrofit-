package com.example.googlebookapi.myadapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.googlebookapi.R
import com.example.googlebookapi.SingleBook
import com.example.googlebookapi.database.BookInfo



class BookAdapterDb(private val context: Context,private val listener : INotesRVAdapter) : RecyclerView.Adapter<BookAdapterDb.MyDbViewHolder>(){

    val allBooks = ArrayList<BookInfo>()

    class MyDbViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imageView  = itemView.findViewById<ImageView>(R.id.imageView1)
        var name  = itemView.findViewById<TextView>(R.id.textView11)
        var author = itemView.findViewById<TextView>(R.id.textView21)
        var publishedDate  = itemView.findViewById<TextView>(R.id.textView31)
        var pageCount  = itemView.findViewById<TextView>(R.id.textView41)
        var price = itemView.findViewById<TextView>(R.id.textView51)
        var button  = itemView.findViewById<Button>(R.id.button21)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDbViewHolder {
        val viewHolder =  MyDbViewHolder(LayoutInflater.from(context).inflate(R.layout.booklayoutdb,parent,false))
        viewHolder.button.setOnClickListener {
            listener.onItemClicked(allBooks[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyDbViewHolder, position: Int) {
        val item = allBooks[position]
        holder.name.text = "NAME: " + item.name.toString()
        holder.author.text = "AUTHOR: " + item.author.toString()
        holder.publishedDate.text = "Published Date: " + item.publishedDate.toString()
        holder.pageCount.text = "LENGTH: " + item.pageCount.toString() + "PAGES"
        holder.price.text = "PRICE " + item.price.toString() + "/-"
        Glide.with(context).load(item.thumbnail.toString()).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return allBooks.size
    }

    fun updateList(newList : List<BookInfo>) {
        allBooks.clear()
        allBooks.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRVAdapter {
    fun onItemClicked(book : BookInfo)
}

