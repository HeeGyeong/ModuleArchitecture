package com.example.core.base

import android.app.Application
import com.example.core.base.util.DataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class.
 * Koin 과 DataStore 를 Setting 해주고 있다.
 *
 * 해당 class 는 Manifest 에 선언하여 사용하기 때문에 별다른 호출부는 존재하지 않는다.
 */
class BaseApplication: Application() {

    private lateinit var dataStore : DataStore

    companion object {
        private lateinit var application: BaseApplication
        fun getInstance() : BaseApplication = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        dataStore = DataStore(this)

        startKoin {
            androidContext(this@BaseApplication)
        }
    }

    fun getDataStore() : DataStore = dataStore
}