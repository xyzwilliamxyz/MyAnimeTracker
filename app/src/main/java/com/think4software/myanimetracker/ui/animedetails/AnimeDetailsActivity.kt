package com.think4software.myanimetracker.ui.animedetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_anime_details.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class AnimeDetailsActivity : AppCompatActivity(), AnimeDetailsContract.View {

    private val presenter: AnimeDetailsContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_details)

        val anime = intent.getParcelableExtra<Anime>(ARGUMENT_ANIME)

        initView(anime)

        presenter.onStart()
    }

    private fun initView(anime: Anime) {
        tv_anime_title.text = anime.title
        GlideUtils.imageIntoView(anime.coverUrl, iv_cover, this)
    }

    override fun showLoading(showHide: Boolean) {
        // TODO implement
    }

    companion object {
        const val ARGUMENT_ANIME = "ARGUMENT_ANIME"

        fun getIntent(context: Context, anime: Anime): Intent {
            return Intent(context, AnimeDetailsActivity::class.java)
                .putExtra(ARGUMENT_ANIME, anime)
        }
    }
}
