package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class AccessInfo {
    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("viewability")
    @Expose
    var viewability: String? = null

    @SerializedName("embeddable")
    @Expose
    var embeddable: Boolean? = null

    @SerializedName("publicDomain")
    @Expose
    var publicDomain: Boolean? = null

    @SerializedName("textToSpeechPermission")
    @Expose
    var textToSpeechPermission: String? = null

    @SerializedName("epub")
    @Expose
    var epub: Epub? = null

    @SerializedName("pdf")
    @Expose
    var pdf: Pdf? = null

    @SerializedName("webReaderLink")
    @Expose
    var webReaderLink: String? = null

    @SerializedName("accessViewStatus")
    @Expose
    var accessViewStatus: String? = null

    @SerializedName("quoteSharingAllowed")
    @Expose
    var quoteSharingAllowed: Boolean? = null
}