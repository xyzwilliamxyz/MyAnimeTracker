package com.think4software.myanimetracker.infrasctructure.di

import com.think4software.myanimetracker.interactors.GetSeasonalAnime
import org.koin.dsl.module

val interactorModule = module {
    factory { GetSeasonalAnime(get()) }
}
