package com.example.cleanarchitecturestudy.view

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecturestudy.BuildConfig
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.databinding.ActivityMainBinding
import com.example.cleanarchitecturestudy.module.*
import com.example.core.base.BaseActivity
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import java.util.concurrent.Executor

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
        initBioMetric()
    }

    private var biometricPrompt: BiometricPrompt? = null
    private var promptInfo: BiometricPrompt.PromptInfo? = null
    private val biometricResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Log.d("BiometricLog", "registerForActivityResult : $result")

            if (result.resultCode == Activity.RESULT_OK) {
                // restart biometric check
                checkUseBiometric()
            } else {
                Log.d("BiometricLog", "result.resultCode != Activity.RESULT_OK")
            }
        }

    private fun initBioMetric() {
        biometricPrompt = setBiometricPrompt()
        promptInfo = setPromptInfo()
    }

    private var executor: Executor? = null
    private fun setBiometricPrompt(): BiometricPrompt {
        executor = ContextCompat.getMainExecutor(this)

        biometricPrompt =
            BiometricPrompt(this, executor!!, object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        this@MainActivity,
                        "errorCode: $errorCode, errString: $errString",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(this@MainActivity, "생체 인증 성공", Toast.LENGTH_SHORT).show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(this@MainActivity, "생체 인증 실패", Toast.LENGTH_SHORT).show()
                }

            })

        return biometricPrompt as BiometricPrompt
    }

    private fun setPromptInfo(): BiometricPrompt.PromptInfo {
        val promptBuilder: BiometricPrompt.PromptInfo.Builder = BiometricPrompt.PromptInfo.Builder()

        promptBuilder.setTitle("Biometric Title")
        promptBuilder.setSubtitle("Biometric subTitle")
        promptBuilder.setDescription("Biometric description")

        // 특정 버전 이상에는 setNegativeButtonText가 필요하지 않아 에러가 발생합니다.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            promptBuilder.setNegativeButtonText("Biometric negativeBtnText")
        }

        // 안면 인식의 경우 Android 11 이상부터 사용이 가능합니다.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            promptBuilder.setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
        }

        promptInfo = promptBuilder.build()
        return promptInfo as BiometricPrompt.PromptInfo
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

    private fun checkUseBiometric() {
        val biometricManager = BiometricManager.from(this@MainActivity)
        when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK)) {

            BiometricManager.BIOMETRIC_SUCCESS -> {
                Log.d("BiometricLog", "BIOMETRIC_SUCCESS :: 사용 가능")
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                Log.d("BiometricLog", "BIOMETRIC_ERROR_NO_HARDWARE :: 지원하지 않는 기기")
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                Log.d("BiometricLog", "BIOMETRIC_ERROR_HW_UNAVAILABLE :: 사용할 수 없는 상태")
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                Log.d("BiometricLog", "BIOMETRIC_ERROR_NONE_ENROLLED :: 생체 인증 정보가 없음")

                val dialogBuilder = AlertDialog.Builder(this@MainActivity)
                dialogBuilder.setTitle("지문이 등록되어있지 않습니다.")
                    .setMessage("지문 등록이 필요합니다. 지문등록 설정화면으로 이동하시겠습니까?")
                    .setPositiveButton("확인") { _, _ -> startSettingPage() }
                    .setNegativeButton("취소") { dialog, _ -> dialog.cancel() }
                dialogBuilder.show()
            }

            else -> {
                Log.d("BiometricLog", "알 수 없는 오류")
            }
        }

        goAuthenticate()
    }

    // 생체 인증 호출
    private fun goAuthenticate() {
        Log.d("BiometricLog", "promptInfo : $promptInfo")
        promptInfo?.let {
            biometricPrompt?.authenticate(it)  //인증 실행
        }
    }

    private fun startSettingPage() {
        // R 버전 이하에서는 FingerPrint를 사용하기 때문에, 다른 Setting 화면 호출 필요.
        val enrollIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                putExtra(
                    Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                    BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                )
            }
        } else {
            // 설정 화면까지만 이동.
            Intent(Settings.ACTION_SECURITY_SETTINGS)
        }

        biometricResult.launch(enrollIntent)
    }

    var goNext = true
    fun btnClick(view: View) {
        when (view.id) {
            R.id.search_btn -> {
                viewModel.setDataStore("insert Search_btn")
                viewModel.changeToActivity(this, "MOVIE")
            }

            R.id.move_btn -> {
                viewModel.setDataStore("insert move_btn")
                viewModel.changeToActivity(this, "MOVE")
            }

            R.id.search_btn_default -> {
                viewModel.setDataStore("insert search_btn_default")
                viewModel.changeToActivity(this, "MOVIE", "GOOD")
            }

            R.id.search_btn_default_bundle -> {
                val bundle = Bundle().also {
                    it.putString("text", "BAD")
                }
                viewModel.setDataStore("insert search_btn_default")
                viewModel.changeToActivity(this, "MOVIE", bundle)
            }

            R.id.biometric_btn -> {
                goNext = false
                checkUseBiometric()
            }
        }

        if (goNext) {
            goNext = true
            finish()
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
                        Toast.makeText(
                            this@MainActivity,
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
