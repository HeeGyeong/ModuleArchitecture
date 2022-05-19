package com.example.cleanarchitecturestudy.module

import com.example.data.repository.search.remote.MovieRemoteDataSource
import com.example.data.repository.search.remote.MovieRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteDataModule: Module = module {
    singleOf(::MovieRemoteDataSourceImpl) bind MovieRemoteDataSource::class
}
