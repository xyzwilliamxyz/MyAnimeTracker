package com.think4software.myanimetracker.infrasctructure.di

import com.think4software.myanimetracker.ui.animedetails.AnimeDetailsContract
import com.think4software.myanimetracker.ui.animedetails.AnimeDetailsPresenter
import com.think4software.myanimetracker.ui.home.HomeContract
import com.think4software.myanimetracker.ui.home.HomePresenter
import com.think4software.myanimetracker.ui.home.seasonal.SeasonalAnimeContract
import com.think4software.myanimetracker.ui.home.seasonal.SeasonalAnimePresenter
import com.think4software.myanimetracker.ui.home.tracking.TrackingAnimeContract
import com.think4software.myanimetracker.ui.home.tracking.TrackingAnimePresenter
import org.koin.dsl.module

val presenterModule = module {
    factory<HomeContract.Presenter> { (view: HomeContract.View) ->  HomePresenter(view) }
    factory<SeasonalAnimeContract.Presenter> { (view: SeasonalAnimeContract.View) ->  SeasonalAnimePresenter(view, get()) }
    factory<TrackingAnimeContract.Presenter> { (view: TrackingAnimeContract.View) ->  TrackingAnimePresenter(view) }
    factory<AnimeDetailsContract.Presenter> { (view: AnimeDetailsContract.View) ->  AnimeDetailsPresenter(view) }
}
