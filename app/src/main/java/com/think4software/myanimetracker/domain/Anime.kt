package com.think4software.myanimetracker.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime(
    val animeId: Int,
    val title: String,
    val coverUrl: String,
    val synopsis: String,
    val type: String,
    val members: Int,
    val score: Float?
) : Parcelable
