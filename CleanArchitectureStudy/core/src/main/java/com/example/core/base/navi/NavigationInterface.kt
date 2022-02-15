package com.example.core.base.navi

import android.content.Context
import com.example.core.base.BaseViewModel

interface NavigationInterface {
    fun changeActivity(context: Context, fromActivity: String?)
}