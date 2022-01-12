package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class ListPrice {
    @SerializedName("amount")
    @Expose
    var amount: Double? = null

    @SerializedName("currencyCode")
    @Expose
    var currencyCode: String? = null
}