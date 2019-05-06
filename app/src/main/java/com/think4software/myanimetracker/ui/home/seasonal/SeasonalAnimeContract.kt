package com.think4software.myanimetracker.ui.home.seasonal

import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.ui.BasePresenter
import com.think4software.myanimetracker.ui.BaseView

interface SeasonalAnimeContract {

    interface Presenter: BasePresenter {

    }

    interface View: BaseView {

        fun setAnimeList(anime: List<Anime>)
    }
}
