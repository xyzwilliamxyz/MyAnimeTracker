package com.think4software.myanimetracker.gateways.remote.response

import com.squareup.moshi.Json

data class SeasonalAnimeResponse(
    @Json(name = "season_year") val year: Int,
    @Json(name = "season_name") val season: String,
    @Json(name = "anime") val animeList: List<AnimeResponse>
)