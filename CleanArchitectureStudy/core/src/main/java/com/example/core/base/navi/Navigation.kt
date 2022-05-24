package com.example.core.base.navi

import android.content.Context
import com.example.core.base.BaseViewModel

/**
 * 화면 이동할 때 사용할 Navigation class
 * Interface 의 구현부를 호출하여 필요한 화면 이동을 실행시킨다.
 * 구현부는 Presentation Module 에 존재한다.
 */
open class Navigation(private val naviInterface: NavigationInterface) {
    operator fun invoke(
        context: Context,
        action: BaseViewModel.ActivityAction?,
        fromActivity: String?,
        data: Any?
    ) = naviInterface.changeActivity(context, action, fromActivity, data)
}
