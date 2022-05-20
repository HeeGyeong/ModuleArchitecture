package com.example.cleanarchitecturestudy.view

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecturestudy.BuildConfig
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
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.coroutines.launch
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

        permissionCheck()
        buildLog()
    }

    private fun buildLog() {
        Log.d("BuildConfigCheck", "BuildConfig.FLAVOR ? ${BuildConfig.FLAVOR}")
        Log.d("BuildConfigCheck", "BuildConfig.APPLICATION_ID ? ${BuildConfig.APPLICATION_ID}")
        Log.d("BuildConfigCheck", "BuildConfig.BUILD_TYPE ? ${BuildConfig.BUILD_TYPE}")
        Log.d("BuildConfigCheck", "BuildConfig.DEBUG ? ${BuildConfig.DEBUG}")

        val packageData = packageManager.getPackageInfo(packageName, 0)
        Log.d("BuildConfigCheck", "packageData.versionName ? ${packageData.versionName}")
        Log.d("BuildConfigCheck", "packageData.versionCode ? ${packageData.versionCode}")
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

    /**
     * TedPermission Library 사용을 해보기 위해 추가.
     */
    private fun permissionCheck() {
        lifecycleScope.launch {
            if (!viewModel.getPermission()) {
                val permissionListener: PermissionListener = object : PermissionListener {
                    override fun onPermissionGranted() {
                        Toast.makeText(this@MainActivity,
                            "권한 설정 완료",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.setPermission()
                    }

                    override fun onPermissionDenied(deniedPermissions: List<String>) {
                        Toast.makeText(
                            this@MainActivity,
                            "권한 거부\n$deniedPermissions",
                            Toast.LENGTH_SHORT
                        ).show()
                        viewModel.setPermission()
                    }
                }

                TedPermission.create()
                    .setPermissionListener(permissionListener)
                    .setRationaleMessage("권한 설정 합시다.")
                    .setRationaleTitle("권한 설정 받는 중")
                    .setRationaleConfirmText("알겠습니다")

                    .setDeniedTitle("권한 설정을 거절.")
                    .setDeniedMessage("권한 설정 하려면 Setting 눌러서 직접 해주세요")
                    .setDeniedCloseButtonText("닫기")

                    .setGotoSettingButtonText("설정하러 가봅시다")
                    .setPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                    .check()
            }
        }
    }
}
