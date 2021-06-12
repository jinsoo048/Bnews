package com.example.bnews.src.main.models.tour.travel

data class Item(
    val galContentId: Int,
    val galContentTypeId: Int,
    val galCreatedtime: Long,
    val galModifiedtime: Long,
    val galPhotographer: String,
    val galPhotographyLocation: String,
    val galPhotographyMonth: Int,
    val galSearchKeyword: String,
    val galTitle: String,
    val galViewCount: Int,
    val galWebImageUrl: String
)