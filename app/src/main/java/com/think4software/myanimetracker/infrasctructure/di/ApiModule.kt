package com.think4software.myanimetracker.infrasctructure.di

import com.think4software.myanimetracker.BuildConfig
import com.think4software.myanimetracker.gateways.remote.AnimeApi
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private val retrofit = provideRetrofitInterface()

val apiModule = module {
    single { retrofit.create(AnimeApi::class.java) }
}

private fun provideRetrofitInterface(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
}
