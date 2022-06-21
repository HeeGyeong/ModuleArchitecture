package com.example.cleanarchitecturestudy.initalizer

import android.content.Context
import android.content.Intent
import com.example.cleanarchitecturestudy.view.MainActivity

class MainInitializer {
    fun startActivity(context: Context, data: Any? = null) {
        if (data == null) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}