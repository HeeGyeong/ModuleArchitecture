package com.example.di.application

import android.app.Application
import com.example.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Koin 을 사용하기 위한 Class
 * context 와 module 을 선언하여 주입시킨다.
 */
class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        callStartKoin()
    }

    private fun callStartKoin() {
        startKoin {
            /*if (BuildConfig.DEBUG) {
                androidLogger()
            } else {
                androidLogger(Level.ERROR)
            }*/
            androidContext(this@KoinApplication)

            /*// vararg 로 넣어서 선언 가능.
            modules(
                apiModule,
                networkModule,
                rankingDataModule,
                repositoryModule,
                selectDataModule,
                viewModelModule
            )*/

            // 개별로 선언 가능
            modules(apiModule)
            modules(localDataModule)
            modules(networkModule)
            modules(remoteDataModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(useCaseModule)
        }
    }
}