package com.example.cleanarchitecturestudy.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityMainBinding
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * MainActivity.
 *
 * 해당 프로젝트에서는 사실 필요성이 없지만, 테스트를 위해 이것 저것 추가해보기 위해 만들어 두었음.
 */
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main)  {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    /**
     * DataStore 관련 소스코드 정제 필요합니다.
     * 예제에 맞게 소스코드 정리 및 함수 명 변경 필요.
     * 버튼 추가하여 데이터 저장, 가져오기 부분 작업해보기.
     * + 각 다른 모듈에서 데이터 저장하고 불러오기 예제 추가.
     */
    private fun callLog() {
        var sam: String? = null

        // dataStore 가져오기. coroutineScope 에서 진행.
        lifecycleScope.launch {
            dataStore.data.collect {
                sam = it[sampleString]
                Log.d("DataStoreSample" , "callLog data ? $sam")
            }
        } }

    fun btnClick(view: View) {
        when(view.id) {
            R.id.search_btn -> {
                setSampleString("123123123")
                callLog()
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVIE"))
            }
            R.id.move_btn -> {
                setSampleString("ABC")
                callLog()
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVE"))
            }
        }
    }
}