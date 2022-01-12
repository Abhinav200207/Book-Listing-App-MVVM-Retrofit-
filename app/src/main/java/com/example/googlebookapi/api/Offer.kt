package com.example.googlebookapi.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Offer {
    @SerializedName("finskyOfferType")
    @Expose
    var finskyOfferType: Int? = null

    @SerializedName("listPrice")
    @Expose
    var listPrice: ListPrice__1? = null

    @SerializedName("retailPrice")
    @Expose
    var retailPrice: RetailPrice__1? = null
}