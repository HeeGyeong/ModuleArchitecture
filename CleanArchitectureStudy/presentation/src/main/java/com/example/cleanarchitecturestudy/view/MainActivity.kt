package com.example.cleanarchitecturestudy.view

import android.os.Bundle
import android.view.View
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityMainBinding
import com.example.cleanarchitecturestudy.module.apiModule
import com.example.cleanarchitecturestudy.module.localDataModule
import com.example.cleanarchitecturestudy.module.navigationModule
import com.example.cleanarchitecturestudy.module.networkModule
import com.example.cleanarchitecturestudy.module.remoteDataModule
import com.example.cleanarchitecturestudy.module.repositoryModule
import com.example.cleanarchitecturestudy.module.useCaseModule
import com.example.cleanarchitecturestudy.module.viewModelModule
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

/**
 * MainActivity.
 *
 * 해당 프로젝트에서는 사실 필요성이 없지만, 테스트를 위해 이것 저것 추가해보기 위해 만들어 두었음.
 */
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadKoinModules(
            listOf(
                navigationModule,
                apiModule,
                localDataModule,
                networkModule,
                remoteDataModule,
                repositoryModule,
                viewModelModule,
                useCaseModule
            )
        )
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.search_btn -> {
                viewModel.setDataStore("insert Search_btn")
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVIE"))
            }

            R.id.move_btn -> {
                viewModel.setDataStore("insert move_btn")
                viewModel.changeToActivity(this, BaseViewModel.FromActivity.MOVE.activity("MOVE"))
            }
        }
    }
}
