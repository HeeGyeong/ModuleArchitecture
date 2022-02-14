package com.example.move

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
import com.example.move.databinding.ActivityMoveBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoveActivity: BaseActivity<ActivityMoveBinding>(R.layout.activity_move) {
    private val viewModel: MoveViewModel by viewModel()

    fun btnClick(view: View) {
        when(view.id) {
            R.id.main_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MAIN)
            }
            R.id.search_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVIE)
            }

            R.id.first_btn -> {
                view.findNavController().navigate(R.id.move_first_fragment)
            }
            R.id.second_btn -> {
                view.findNavController().navigate(R.id.move_second_fragment)
            }
            R.id.third_btn -> {
                view.findNavController().navigate(R.id.move_third_fragment)
            }
        }
    }
}