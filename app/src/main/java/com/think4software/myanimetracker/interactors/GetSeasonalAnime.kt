package com.think4software.myanimetracker.interactors

import com.think4software.myanimetracker.gateways.converters.AnimeConverter
import com.think4software.myanimetracker.gateways.remote.AnimeApi
import com.think4software.myanimetracker.ui.home.seasonal.SeasonalAnimePresenter.SeasonalAnimeApiCallback
import com.think4software.myanimetracker.utils.DateUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GetSeasonalAnime constructor(private val animeApi: AnimeApi) {

    private val disposable = CompositeDisposable()

    fun execute(year: Int = DateUtils.getCurrentYear(), season: String = DateUtils.getCurrentSeason(),
                callback: SeasonalAnimeApiCallback) {
        disposable.add(
            animeApi.getSeasonalAnime(year, season)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { callback.onTerminate() }
                .map { result -> AnimeConverter.fromResponse(result.animeList) }
                .subscribe(
                    { result -> callback.onSuccess(result) },
                    { callback.onError() }
                )
        )
    }

    fun dispose() {
        disposable.dispose()
    }
}
