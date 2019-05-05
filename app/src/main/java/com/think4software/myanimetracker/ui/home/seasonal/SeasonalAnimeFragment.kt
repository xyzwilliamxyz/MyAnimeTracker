package com.think4software.myanimetracker.ui.home.seasonal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.think4software.myanimetracker.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf



class SeasonalAnimeFragment: Fragment(), SeasonalAnimeContract.View {

    private val presenter: SeasonalAnimeContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_seasonal_anime, container, false)

        activity?.setTitle(R.string.seasonal_anime)

        presenter.onStart()

        return view
    }

    override fun showLoading(showHide: Boolean) {
        // TODO not implemented
    }
}
