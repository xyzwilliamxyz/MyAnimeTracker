package com.think4software.myanimetracker.gateways.converters

import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.gateways.remote.response.AnimeResponse
import com.think4software.myanimetracker.utils.Constants.ANIME_DOMAIN_TYPE
import com.think4software.myanimetracker.utils.Constants.ANIME_RESPONSE_TYPE

object AnimeConverter {

    fun fromResponse(animeResponse: AnimeResponse): Anime {
        return Anime(
            animeResponse.animeId,
            animeResponse.title,
            animeResponse.coverUrl,
            animeResponse.synopsis,
            getConvertedType(animeResponse.type),
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

    private fun getConvertedType(type: String): String {
        return if (type == ANIME_RESPONSE_TYPE) ANIME_DOMAIN_TYPE
        else type
    }
}
