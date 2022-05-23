package com.example.move.view

import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
import com.example.move.R
import com.example.move.databinding.ActivityMoveBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 화면 이동에 대한 테스트를 위해 만든 Activity.
 *
 * Coordinator 를 사용한 Module 간의 이동.
 * DataStore 를 사용한 Data 저장.
 * AAC Navigation 을 사용한 Fragment 간의 이동.
 */
class MoveActivity : BaseActivity<ActivityMoveBinding>(R.layout.activity_move) {
    private val viewModel: MoveViewModel by viewModel()

    fun btnClick(view: View) {
        when (view.id) {
            R.id.main_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MAIN"))
                finish()
            }
            R.id.search_btn -> {
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVIE"))
                finish()
            }
            R.id.set_data_store -> {
                viewModel.setDataStore("insert Move")
            }
            R.id.get_data_store -> {
                lifecycleScope.launch {
                    Log.d("DataStoreCheck", "result ? ${viewModel.getDataStore()}")
                }
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
