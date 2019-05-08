package com.think4software.myanimetracker.ui.home.seasonal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.ui.animedetails.AnimeDetailsActivity
import kotlinx.android.synthetic.main.fragment_seasonal_anime.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf



class SeasonalAnimeFragment: Fragment(), SeasonalAnimeContract.View {

    private val presenter: SeasonalAnimeContract.Presenter by inject { parametersOf(this) }

    private lateinit var seasonalAnimeAdapter: SeasonalAnimeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_seasonal_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setTitle(R.string.seasonal_anime)
        initView()
        presenter.onStart()
    }

    override fun setAnimeList(anime: List<Anime>) {
        seasonalAnimeAdapter.setAnimeList(anime)
    }

    private fun initView() {
        seasonalAnimeAdapter = SeasonalAnimeAdapter(activity!!, ::onItemClick, ::onTrackClick)
        rv_anime.adapter = seasonalAnimeAdapter
    }

    override fun showLoading(showHide: Boolean) {
        if (showHide) {
            pb_loading.visibility = View.VISIBLE
        } else {
            pb_loading.visibility = View.GONE
        }
    }

    private fun onItemClick(anime: Anime) {
        presenter.openAnime(anime)
    }

    private fun onTrackClick(anime: Anime) {
        presenter.toggleTracking(anime)
    }

    override fun openAnimeScreen(anime: Anime) {
        startActivity(AnimeDetailsActivity.getIntent(activity!!, anime))
    }
}
