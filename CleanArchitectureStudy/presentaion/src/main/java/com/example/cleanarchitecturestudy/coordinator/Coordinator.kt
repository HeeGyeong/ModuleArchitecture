package com.example.cleanarchitecturestudy.coordinator

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.cleanarchitecturestudy.view.MainActivity
import com.example.core.base.navi.NavigationInterface
import com.example.move.initializer.MoveInitializer
import com.example.moviesearch.initializer.MovieSearchInitializer

class Coordinator: NavigationInterface {
    override fun changeActivity(context: Context, fromActivity: String?) {
        Log.d("StartLogCheck" , "NavigationController $context -> $fromActivity")
        when(fromActivity) {
            "MAIN" -> {
                context.startActivity(Intent(context, MainActivity::class.java))
            }
            "MOVIE" -> {
                MovieSearchInitializer().startActivity(context)
            }
            "MOVE" -> {
                MoveInitializer().startActivity(context)
            }
            else -> {
                Log.d("StartLogCheck" , "in Else .. insert value ? $fromActivity")
            }
        }
    }
}