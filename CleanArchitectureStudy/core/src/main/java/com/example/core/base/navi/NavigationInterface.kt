package com.example.core.base.navi

import android.content.Context
import com.example.core.base.BaseViewModel

/**
 * 화면 이동에 사용하는 Interface
 *
 * 추후, 화면 이동에 필요한 데이터를 넘겨야 하는 경우 등
 * 매개 변수가 달라지면 이곳에서 추가해야 하는지 여부 판단을 해야한다.
 */
interface NavigationInterface {
    fun changeActivity(context: Context, fromActivity: String?)
}