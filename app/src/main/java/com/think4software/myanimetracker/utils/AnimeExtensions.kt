package com.think4software.myanimetracker.utils

import com.think4software.myanimetracker.domain.Anime

fun Anime.getScoreAsString(): String {
    return if (score == null) Constants.NOT_APPLICABLE
    else "%.2f".format(score)
}
