package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class ReadingModes {
    @SerializedName("text")
    @Expose
    var text: Boolean? = null

    @SerializedName("image")
    @Expose
    var image: Boolean? = null
}