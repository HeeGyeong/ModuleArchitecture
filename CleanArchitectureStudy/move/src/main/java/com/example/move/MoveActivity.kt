package com.example.move

import android.os.Bundle
import android.view.View
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
import com.example.move.databinding.ActivityMoveBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoveActivity: BaseActivity<ActivityMoveBinding>(R.layout.activity_move) {
    private val viewModel: MoveViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun btnClick(view: View) {
        when(view.id) {
            R.id.main_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MAIN)
            }
            R.id.search_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVIE)
            }
            R.id.move_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE)
            }
        }
    }
}