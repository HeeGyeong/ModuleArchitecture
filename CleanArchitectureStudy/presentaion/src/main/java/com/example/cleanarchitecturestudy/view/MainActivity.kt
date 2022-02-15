package com.example.cleanarchitecturestudy.view

import android.os.Bundle
import android.view.View
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityMainBinding
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
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

    fun btnClick(view: View) {
        when(view.id) {
            R.id.search_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVIE"))
            }
            R.id.move_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVE"))
            }
        }
    }
}