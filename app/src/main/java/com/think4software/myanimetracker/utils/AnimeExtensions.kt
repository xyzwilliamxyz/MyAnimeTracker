package com.think4software.myanimetracker.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.utils.Constants.ANIMATION_TYPE_ANIME
import com.think4software.myanimetracker.utils.Constants.ANIMATION_TYPE_MOVIE
import com.think4software.myanimetracker.utils.Constants.ANIMATION_TYPE_ONA
import com.think4software.myanimetracker.utils.Constants.ANIMATION_TYPE_OVA
import com.think4software.myanimetracker.utils.Constants.ANIMATION_TYPE_SPECIAL

fun Anime.getScoreAsString(): String {
    return if (score == null) Constants.NOT_APPLICABLE
    else "%.2f".format(score)
}

fun Anime.getAnimationTypeColor(context: Context): Int {
    return when (type) {
        ANIMATION_TYPE_ANIME -> {
            ContextCompat.getColor(context, R.color.animeAnimationType)
        }
        ANIMATION_TYPE_MOVIE -> {
            ContextCompat.getColor(context, R.color.movieAnimationType)
        }
        ANIMATION_TYPE_OVA, ANIMATION_TYPE_ONA, ANIMATION_TYPE_SPECIAL -> {
            ContextCompat.getColor(context, R.color.specialsAnimationType)
        }
        else -> {
            ContextCompat.getColor(context, R.color.othersAnimationType)
        }
    }
}
