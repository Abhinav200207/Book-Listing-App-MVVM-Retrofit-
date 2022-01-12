package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Epub {
    @SerializedName("isAvailable")
    @Expose
    var isAvailable: Boolean? = null

    @SerializedName("acsTokenLink")
    @Expose
    var acsTokenLink: String? = null
}