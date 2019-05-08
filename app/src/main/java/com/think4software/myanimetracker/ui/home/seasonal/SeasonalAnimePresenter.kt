package com.think4software.myanimetracker.ui.home.seasonal

import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.gateways.remote.callback.ApiCallback
import com.think4software.myanimetracker.interactors.GetSeasonalAnime

class SeasonalAnimePresenter(private val view: SeasonalAnimeContract.View,
                             private val getSeasonalAnime: GetSeasonalAnime): SeasonalAnimeContract.Presenter {

    override fun onStart() {
        view.showLoading(true)
        getSeasonalAnime.execute(callback = SeasonalAnimeApiCallback())
    }

    override fun onFinish() {
        getSeasonalAnime.dispose()
    }

    override fun openAnime(anime: Anime) {
        view.openAnimeScreen(anime)
    }

    override fun toggleTracking(anime: Anime) {
        // TODO implement
    }

    inner class SeasonalAnimeApiCallback: ApiCallback<List<Anime>> {
        override fun onSuccess(result: List<Anime>) {
            view.setAnimeList(result)
        }

        override fun onError() {
            // TODO not implemented
        }

        override fun onTerminate() {
            view.showLoading(false)
        }
    }
}
