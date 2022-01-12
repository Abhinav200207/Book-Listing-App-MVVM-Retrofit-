package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Item {
    @SerializedName("kind")
    @Expose
    var kind: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("etag")
    @Expose
    var etag: String? = null

    @SerializedName("selfLink")
    @Expose
    var selfLink: String? = null

    @SerializedName("volumeInfo")
    @Expose
    var volumeInfo: VolumeInfo? = null

    @SerializedName("saleInfo")
    @Expose
    var saleInfo: SaleInfo? = null

    @SerializedName("accessInfo")
    @Expose
    var accessInfo: AccessInfo? = null

    @SerializedName("searchInfo")
    @Expose
    var searchInfo: SearchInfo? = null
}