package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Books {
    @SerializedName("kind")
    @Expose
    var kind: String? = null

    @SerializedName("totalItems")
    @Expose
    var totalItems: Int? = null

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
}