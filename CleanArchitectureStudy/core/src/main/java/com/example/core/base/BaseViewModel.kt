package com.example.core.base

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.base.navi.Navigation
import io.reactivex.disposables.CompositeDisposable

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

    fun changeToActivity(context: Context, fromActivity: String?) {
        Log.d("StartLogCheck" , "baseActivity changeToActivity $context -> $fromActivity")
        navigation(context, fromActivity)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    enum class FromActivity(val activity: (String?) -> String?) {
        MOVE({ it }),
        BACK({ it })
    }
}