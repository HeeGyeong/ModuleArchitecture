package com.example.cleanarchitecturestudy.coordinator

import android.content.Context
import android.util.Log
import com.example.cleanarchitecturestudy.initalizer.MainInitializer
import com.example.core.base.navi.NavigationInterface
import com.example.move.initializer.MoveInitializer
import com.example.moviesearch.initializer.MovieSearchInitializer

/**
 * 외부 Module 을 호출하여 Activity 이동을 하기 위한 Coordinator.
 *
 * 각 화면을 Module 로 나눠두었기 때문에, Activity 의 이동을 Coordinator Pattern 을 사용하여 구현해보았다.
 * Main 의 경우 같은 Module 이기 때문에 그대로 StartActivity 를 호출하였고,
 * 다른 케이스의 경우 외두 Module 이기 때문에 해당 Module 을 사용할 수 있는 Initializer 를 통해 접근 하도록 하였다.
 */
class Coordinator : NavigationInterface {
    override fun changeActivity(
        context: Context,
        fromActivity: String?,
        data: Any?,
    ) {
        Log.d("Coordinator", "NavigationController $fromActivity , data ? $data")
        when (fromActivity) {
            "MAIN" -> {
                MainInitializer().startActivity(context, data)
            }
            "MOVIE" -> {
                MovieSearchInitializer().startActivity(context, data)
            }
            "MOVE" -> {
                MoveInitializer().startActivity(context, data)
            }
            else -> {
                Log.d("Coordinator", "in else .. what u want ? $fromActivity")
            }
        }
    }
}
