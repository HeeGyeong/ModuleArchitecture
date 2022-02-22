package com.example.core.base.navi

import android.content.Context

/**
 * 화면 이동할 때 사용할 Navigation class
 * Interface 의 구현부를 호출하여 필요한 화면 이동을 실행시킨다.
 * 구현부는 Presentation Module 에 존재한다.
 */
class Navigation(private val naviInterface: NavigationInterface) {
    operator fun invoke(
        context: Context,
        fromActivity: String?
    ) = naviInterface.changeActivity(context, fromActivity)
}
