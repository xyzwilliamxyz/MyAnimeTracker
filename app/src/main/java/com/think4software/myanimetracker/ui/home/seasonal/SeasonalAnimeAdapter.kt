package com.think4software.myanimetracker.ui.home.seasonal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.infrasctructure.glide.GlideApp
import com.think4software.myanimetracker.utils.Constants
import com.think4software.myanimetracker.utils.GlideUtils
import com.think4software.myanimetracker.utils.getScoreAsString
import kotlinx.android.synthetic.main.item_anime.view.*
import kotlinx.android.synthetic.main.view_tracking.view.*


class SeasonalAnimeAdapter(private val context: Context/*, private val listener: OnAnimeClickListener*/)
    : RecyclerView.Adapter<SeasonalAnimeAdapter.AnimeViewHolder>() {

    private var anime: MutableList<Anime> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent,false)
        return AnimeViewHolder(view).bindEvent()
    }

    fun setAnimeList(anime: List<Anime>) {
        this.anime.clear()
        this.anime.addAll(anime)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return anime.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.title.text = anime[position].title
        holder.subtitle.text = anime[position].type
        holder.score.text = "${Constants.STAR_CHARACTER} ${anime[position].getScoreAsString()}"

        // TODO remove later
        if (position in 0..3) {
            holder.watching.setColorFilter(ContextCompat.getColor(context, R.color.trackingColor))
        } else {
            holder.watching.setColorFilter(ContextCompat.getColor(context, R.color.notTrackingColor))
        }

        GlideUtils.imageIntoView(anime[position].coverUrl, holder.cover, context)
    }

    inner class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_title
        val subtitle: TextView = view.tv_type
        val cover: ImageView = view.iv_cover
        val score: TextView = view.tv_score
        val watching: ImageView = view.iv_tracking
//        private val item: ViewGroup = view.cl_item_movie

        fun bindEvent(): AnimeViewHolder {
//            item.setOnClickListener {
//                listener.openMovie(anime[adapterPosition])
//            }
            return this
        }
    }
}
