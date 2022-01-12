package com.example.googlebookapi.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
class BookInfo(
    val name : String,
    val author : String,
    val publishedDate : String,
    val pageCount : String,
    val price : String,
    val thumbnail : String,
    val selfLink : String,
    val buyLink : String) {
        @PrimaryKey(autoGenerate = true) var id = 0
}