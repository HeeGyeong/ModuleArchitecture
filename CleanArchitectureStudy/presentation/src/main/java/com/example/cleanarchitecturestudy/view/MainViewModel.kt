package com.example.cleanarchitecturestudy.view

import com.example.core.base.BaseApplication
import com.example.core.base.BaseViewModel
import com.example.core.base.navi.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val navigation: Navigation
) : BaseViewModel(navigation) {

    suspend fun getPermission(): Boolean =
        withContext(CoroutineScope(Dispatchers.Main).coroutineContext) {
            BaseApplication.getInstance().getDataStore().dataStorePermission.first()
        }

    fun setPermission() {
        CoroutineScope(Dispatchers.Main).launch {
            BaseApplication.getInstance().getDataStore().setDataStorePermission(true)
        }
    }

}

