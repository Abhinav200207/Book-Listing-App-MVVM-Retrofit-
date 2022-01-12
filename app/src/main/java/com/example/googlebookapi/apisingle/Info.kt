package com.example.googlebookapi.apisingle

data class Info(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val layerInfo: LayerInfo,
    val saleInfo: SaleInfo,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)