package com.example.core.base.navi

import android.content.Context
import com.example.core.base.BaseViewModel

class Navigation(private val naviInterface: NavigationInterface) {
    operator fun invoke(
        context: Context,
        fromActivity: BaseViewModel.FromActivity
    ) = naviInterface.changeActivity(context, fromActivity)
}