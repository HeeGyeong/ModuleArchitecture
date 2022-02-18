package com.example.move.initializer

import android.content.Context
import android.content.Intent
import com.example.move.view.MoveActivity

class MoveInitializer {

    fun startActivity(context: Context) {
        context.startActivity(Intent(context, MoveActivity::class.java))
    }
}