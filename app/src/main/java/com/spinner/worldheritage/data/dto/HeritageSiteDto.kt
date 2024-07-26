package com.spinner.worldheritage.data.dto

import com.spinner.worldheritage.domain.model.HeritageSite

data class HeritageSiteDto(
    val id: String,
    val year: Int,
    val target: String,
    val name: String,
    val type: String,
    val region: String,
    val regionLong: String,
    val coordinates: String,
    val lat: Double,
    val lng: Double,
    val page: String,
    val image: String,
    val imageAuthor: String,
    val shortInfo: String,
    val longInfo: String
)

fun HeritageSiteDto.toHeritageSite(): HeritageSite {
    return HeritageSite(
        id = id,
        year = year,
        name = name,
        regionLong = regionLong,
        image = imageAuthor,
    )
}