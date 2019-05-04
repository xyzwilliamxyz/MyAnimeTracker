package com.think4software.myanimetracker.domain

data class Anime(
    val animeId: Int,
    val title: String,
    val coverUrl: String,
    val synopsis: String,
    val type: String,
    val members: String,
    val score: Float
)