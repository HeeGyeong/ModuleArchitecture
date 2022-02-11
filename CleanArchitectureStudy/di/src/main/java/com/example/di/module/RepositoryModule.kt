package com.example.di.module

import com.example.local.repository.search.MovieRepositoryImpl
import com.example.moviesearch.domain.repository.MovieRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Repository 에 관련 된 Module
 */
val repositoryModule: Module = module {

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}