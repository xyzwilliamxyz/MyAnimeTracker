package com.think4software.myanimetracker.ui.home.seasonal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.domain.Anime
import com.think4software.myanimetracker.infrasctructure.glide.GlideApp
import kotlinx.android.synthetic.main.item_anime.view.*


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

        val circularProgressDrawable = CircularProgressDrawable(context)
                circularProgressDrawable.strokeWidth = STROKE_WIDTH
                circularProgressDrawable.centerRadius = CENTER_RADIUS
                circularProgressDrawable.start()

        GlideApp.with(context)
            .load(anime[position].coverUrl)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.cover_not_found)
            .into(holder.cover)
    }

    inner class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tv_title
        val subtitle: TextView = view.tv_type
        val cover: ImageView = view.iv_cover
//        private val item: ViewGroup = view.cl_item_movie

        fun bindEvent(): AnimeViewHolder {
//            item.setOnClickListener {
//                listener.openMovie(anime[adapterPosition])
//            }
            return this
        }
    }

    companion object {
        private const val STROKE_WIDTH = 5f
        private const val CENTER_RADIUS = 30f
    }
}
