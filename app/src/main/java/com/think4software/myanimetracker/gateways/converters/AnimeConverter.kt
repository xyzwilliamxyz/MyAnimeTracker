package com.think4software.myanimetracker.gateways.converters

import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.gateways.remote.response.AnimeResponse

object AnimeConverter {

    fun fromResponse(animeResponse: AnimeResponse): Anime {
        return Anime(
            animeResponse.animeId,
            animeResponse.title,
            animeResponse.coverUrl,
            animeResponse.synopsis,
            animeResponse.type,
            animeResponse.members,
            animeResponse.score
        )
    }

    fun fromResponse(animeResponse: List<AnimeResponse>?): List<Anime> {
        val anime = mutableListOf<Anime>()
        animeResponse?.forEach {
            anime.add(fromResponse(it))
        }
        return anime
    }
}
