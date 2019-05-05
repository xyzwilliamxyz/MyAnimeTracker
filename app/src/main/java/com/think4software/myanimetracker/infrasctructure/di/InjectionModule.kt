package com.think4software.myanimetracker.infrasctructure.di

import com.think4software.myanimetracker.ui.home.HomeContract
import com.think4software.myanimetracker.ui.home.HomePresenter
import org.koin.dsl.module

val presenterModule = module {
    single<HomeContract.Presenter> { (view: HomeContract.View) ->  HomePresenter(view) }
}