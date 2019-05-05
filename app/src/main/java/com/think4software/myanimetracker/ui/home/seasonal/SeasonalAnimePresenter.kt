package com.think4software.myanimetracker.ui.home.seasonal

import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.gateways.remote.callback.ApiCallback
import com.think4software.myanimetracker.interactors.GetSeasonalAnime

class SeasonalAnimePresenter(private val view: SeasonalAnimeContract.View,
                             private val getSeasonalAnime: GetSeasonalAnime): SeasonalAnimeContract.Presenter {

    override fun onStart() {
        getSeasonalAnime.execute(callback = SeasonalAnimeApiCallback())
    }

    override fun onFinish() {
        getSeasonalAnime.dispose()
    }

    inner class SeasonalAnimeApiCallback: ApiCallback<List<Anime>> {
        override fun onSuccess(result: List<Anime>) {
            // TODO not implemented
        }

        override fun onError() {
            // TODO not implemented
        }

        override fun onTerminate() {
            // TODO not implemented
        }
    }
}
