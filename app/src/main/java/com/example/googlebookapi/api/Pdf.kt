package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Pdf {
    @SerializedName("isAvailable")
    @Expose
    var isAvailable: Boolean? = null
}