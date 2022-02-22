package com.example.moviesearch.initializer

import android.content.Context
import android.content.Intent
import com.example.moviesearch.view.MovieSearchActivity

/**
 * Presentation Module 에서 Coordinator 를 통해 해당 Module 에 접근하는 허브 역할을 한다.
 *
 * 외부에서 해당 모듈을 접근 할 떄, 직접 호출이 아닌 Initializer 를 통해서만 접근하도록 하기 위해서 사용한다.
 */
class MovieSearchInitializer {
    fun startActivity(context: Context) {
        context.startActivity(Intent(context, MovieSearchActivity::class.java))
    }
}
