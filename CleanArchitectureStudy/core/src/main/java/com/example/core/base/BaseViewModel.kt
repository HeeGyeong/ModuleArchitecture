package com.example.core.base

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.base.navi.Navigation
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * BaseViewModel
 */
abstract class BaseViewModel(private val navigation: Navigation) : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()

    // LiveData 를 사용하여 ProgressBar 를 On/Off 시킨다. 해당 변수를 사용하는 곳은 movie_search.xml
    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun showProgress() {
        _isLoading.value = true
    }

    fun hideProgress() {
        _isLoading.value = false
    }

    // Navigator 를 사용한 Activity 이동
    fun changeToActivity(context: Context, fromActivity: String?) {
        Log.d("changeToActivity" , "baseActivity changeToActivity $context -> $fromActivity")
        navigation(context, fromActivity)
    }

    /**
     * DataStore 사용을 위한 get
     *
     * await() 를 사용하기 위하여 suspend 로 사용.
     * 동기화 된 상태로 해당 값을 가져오는 것이 아닌 비동기로 값을 사용한다면 await 를 사용하지 않아도 된다.
     */
    suspend fun getDataStore(): String = CoroutineScope(Dispatchers.Main).async {
        BaseApplication.getInstance().getDataStore().dataStoreText.first()
    }.await()

    // collect 를 사용하는 경우 이처럼 사용한다. 실 사용부분은 아님.
    fun getDataStore2(): String {
        var save: String = ""
        CoroutineScope(Dispatchers.Main).launch {
            BaseApplication.getInstance().getDataStore().dataStoreText.collect {
                save = it
            }
        }

        return save
    }

    /**
     * DataStore 사용을 위한 set
     */
    fun setDataStore(text: String) {
        CoroutineScope(Dispatchers.Main).launch {
            BaseApplication.getInstance().getDataStore().setDataStoreText(text)
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    // enum class 를 사용하는 이유는, 호출 부분에서 행동을 제한하기 위해서이다.
    enum class FromActivity(val activity: (String?) -> String?) {
        MOVE({ it }),
        BACK({ it })
    }
}