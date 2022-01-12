package com.example.googlebookapi.api

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class PanelizationSummary {
    @SerializedName("containsEpubBubbles")
    @Expose
    var containsEpubBubbles: Boolean? = null

    @SerializedName("containsImageBubbles")
    @Expose
    var containsImageBubbles: Boolean? = null
}