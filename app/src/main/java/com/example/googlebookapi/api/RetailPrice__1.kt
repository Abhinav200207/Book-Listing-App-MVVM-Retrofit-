package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class RetailPrice__1 {
    @SerializedName("amountInMicros")
    @Expose
    var amountInMicros: Long? = null

    @SerializedName("currencyCode")
    @Expose
    var currencyCode: String? = null
}