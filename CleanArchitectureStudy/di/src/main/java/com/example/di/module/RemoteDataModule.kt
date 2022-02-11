package com.example.di.module

import com.example.api.repository.MovieRemoteDataSource
import com.example.api.repository.MovieRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteDataModule: Module = module {
   single<MovieRemoteDataSource> { MovieRemoteDataSourceImpl(get()) }
}