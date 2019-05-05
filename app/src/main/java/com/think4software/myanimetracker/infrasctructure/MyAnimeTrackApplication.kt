package com.think4software.myanimetracker.infrasctructure

import android.app.Application
import com.think4software.myanimetracker.infrasctructure.di.apiModule
import com.think4software.myanimetracker.infrasctructure.di.interactorModule
import com.think4software.myanimetracker.infrasctructure.di.presenterModule
import org.koin.core.context.startKoin

class MyAnimeTrackApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(apiModule, interactorModule, presenterModule)
        }
    }
}
