package com.example.moviesearch.initializer

import android.content.Context
import android.content.Intent
import com.example.moviesearch.view.MovieSearchActivity

class MovieSearchInitializer {

    fun startActivity(context: Context) {
        context.startActivity(Intent(context, MovieSearchActivity::class.java))
    }
}