package com.example.moviesearch.initializer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.moviesearch.view.MovieSearchActivity

/**
 * Presentation Module 에서 Coordinator 를 통해 해당 Module 에 접근하는 허브 역할을 한다.
 *
 * 외부에서 해당 모듈을 접근 할 떄, 직접 호출이 아닌 Initializer 를 통해서만 접근하도록 하기 위해서 사용한다.
 */
class MovieSearchInitializer {
    fun startActivity(context: Context, data: Any? = null) {
        if (data == null) {
            context.startActivity(Intent(context, MovieSearchActivity::class.java))
        } else {
            var subString = data.toString()

            if (subString.length >= 7) {
                subString = data.toString().substring(0, 7) // appName : 7
            }

            Log.d("DataCheck", "subString ? $subString")

            // 전달 받은 Data에 따라 분기처리.
            when {
                subString.contains("Bundle") -> {
                    // Bundle 사용
                    // Bundle[{bundle_id_key=0000166601, target_url_key=shop/beautySelectView}]

                    context.startActivity(
                        Intent().run {
                            putExtras(data as Bundle)
                            setClass(context, MovieSearchActivity::class.java)
                        }
                    )
                }
                subString.contains("GOOD") -> {
                    context.startActivity(
                        Intent().run {
                            putExtra("text", data as String)
                            setClass(context, MovieSearchActivity::class.java)
                        }
                    )
                }
                // DeepLink 고려.
                subString.contains("appName") -> {
                }
                subString.contains("https") -> {
                }
                else -> {

                }
            }
        }
    }
}
