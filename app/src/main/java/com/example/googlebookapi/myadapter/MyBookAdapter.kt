package com.example.googlebookapi.myadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebookapi.R
import com.example.googlebookapi.api.Item
import android.content.Intent
import com.bumptech.glide.Glide
import com.example.googlebookapi.SingleBook


class BookAdapter(private val context: Context, private val book : List<Item>) : RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    lateinit var price : String
    lateinit var buyLink : String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewHolder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.bookslayout,parent,false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = book[position]
        holder.name.text = "NAME: " + item.volumeInfo?.title.toString()
        holder.author.text = "AUTHOR: " + item.volumeInfo?.authors?.get(0).toString() //+ " " + item.volumeInfo.authors.get(1)
        holder.publishedDate.text = "Published Date: " + item.volumeInfo?.publishedDate.toString()
        holder.pageCount.text = "LENGTH: " + item.volumeInfo?.pageCount.toString() + "PAGES"
        val isSale = item.saleInfo?.saleability.toString()
        if (isSale == "FOR_SALE"){
            price = item.saleInfo?.retailPrice?.amount.toString()
            buyLink = item.saleInfo?.buyLink.toString()
            holder.price.text = "PRICE " + price + "/-"
        }
        else{
            buyLink = "Not for sale"
            price = item.saleInfo?.saleability.toString()
            holder.price.text = price
        }

        val i = Intent(context, SingleBook::class.java)
        val pos = holder.adapterPosition
        i.putExtra("id",item.id)
        i.putExtra("author_name",item.volumeInfo?.authors?.get(0).toString())
        i.putExtra("page_count",item.volumeInfo?.pageCount.toString())
        i.putExtra("name",item.volumeInfo?.title.toString())
        i.putExtra("publishedDate",item.volumeInfo?.publishedDate.toString())
        i.putExtra("description",item.volumeInfo?.description.toString())
        i.putExtra("selfLink",item.selfLink?.toString())
        i.putExtra("thumbnail",item.volumeInfo?.imageLinks?.thumbnail.toString())
        i.putExtra("price",price)
        i.putExtra("buyLink",buyLink)

        holder.button.setOnClickListener(View.OnClickListener {
            context.startActivity(i)
        })
        Glide.with(context).load(item.volumeInfo?.imageLinks?.thumbnail.toString()).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return book.size
    }

    class MyViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        var imageView  = itemView.findViewById<ImageView>(R.id.imageView)
        var name  = itemView.findViewById<TextView>(R.id.textView1)
        //        var subtitle = itemView.findViewById<TextView>(R.id.textView2)
        var author = itemView.findViewById<TextView>(R.id.textView2)
        var publishedDate  = itemView.findViewById<TextView>(R.id.textView3)
        var pageCount  = itemView.findViewById<TextView>(R.id.textView4)
        var price = itemView.findViewById<TextView>(R.id.textView5)
        var button  = itemView.findViewById<Button>(R.id.button2)
    }
}