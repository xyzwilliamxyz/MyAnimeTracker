package com.think4software.myanimetracker.gateways.remote.response

import com.squareup.moshi.Json

data class AnimeResponse(
    @Json(name = "mal_id") val animeId: Int,
    val title: String,
    @Json(name = "image_url") val coverUrl: String,
    val synopsis: String,
    val type: String,
    val members: Int,
    val score: Float?
)
