package com.example.cleanarchitecturestudy.navigation

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.cleanarchitecturestudy.view.MainActivity
import com.example.core.base.navi.NavigationInterface
import com.example.move.MoveActivity
import com.example.moviesearch.search.MovieSearchActivity

class NavigationController: NavigationInterface {
    override fun changeActivity(context: Context, fromActivity: String?) {
        Log.d("StartLogCheck" , "NavigationController $context -> $fromActivity")
        when(fromActivity) {
            "MAIN" -> {
                context.startActivity(Intent(context, MainActivity::class.java))
            }
            "MOVIE" -> {
                context.startActivity(Intent(context, MovieSearchActivity::class.java))
            }
            "MOVE" -> {
                context.startActivity(Intent(context, MoveActivity::class.java))
            }
            else -> {
                Log.d("StartLogCheck" , "in Else .. insert value ? $fromActivity")
            }
        }
    }
}