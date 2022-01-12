package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class SearchInfo {
    @SerializedName("textSnippet")
    @Expose
    var textSnippet: String? = null
}