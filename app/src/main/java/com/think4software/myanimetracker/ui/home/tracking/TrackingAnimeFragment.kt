package com.think4software.myanimetracker.ui.home.tracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.think4software.myanimetracker.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class TrackingAnimeFragment: Fragment(), TrackingAnimeContract.View {

    private val presenter: TrackingAnimeContract.Presenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tracking_anime, container, false)

        activity?.setTitle(R.string.tracking)

        return view
    }

    override fun showLoading(showHide: Boolean) {

    }
}
