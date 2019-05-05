package com.think4software.myanimetracker.gateways.remote

import com.think4software.myanimetracker.gateways.remote.response.AnimeResponse
import com.think4software.myanimetracker.gateways.remote.response.SeasonalAnimeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {

    @GET("season/{year}/{season}")
    fun getSeasonalAnime(@Path("year") year: Int, @Path("season") season: String): Observable<SeasonalAnimeResponse>

    @GET("anime/{animeId}")
    fun getAnimeDetails(@Path("animeId") animeId: Int): Observable<AnimeResponse>
}
