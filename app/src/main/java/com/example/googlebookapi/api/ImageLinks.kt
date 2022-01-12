package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class ImageLinks {
    @SerializedName("smallThumbnail")
    @Expose
    var smallThumbnail: String? = null

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
}