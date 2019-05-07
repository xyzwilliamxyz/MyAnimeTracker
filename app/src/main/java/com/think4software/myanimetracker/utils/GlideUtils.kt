package com.think4software.myanimetracker.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.think4software.myanimetracker.R
import com.think4software.myanimetracker.infrasctructure.glide.GlideApp

object GlideUtils {
    private const val STROKE_WIDTH = 5f
    private const val CENTER_RADIUS = 30f

    fun imageIntoView(url: String, imageView: ImageView, context: Context) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = STROKE_WIDTH
        circularProgressDrawable.centerRadius = CENTER_RADIUS
        circularProgressDrawable.start()

        GlideApp.with(context)
            .load(url)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.cover_not_found)
            .into(imageView)
    }
}
