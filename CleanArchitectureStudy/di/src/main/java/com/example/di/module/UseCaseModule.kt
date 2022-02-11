package com.example.di.module

import com.example.moviesearch.domain.usecase.GetLocalMoviesUseCase
import com.example.moviesearch.domain.usecase.GetMoviesUseCase
import com.example.moviesearch.domain.usecase.GetPagingMoviesUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * useCase 에 관련 된 Module.
 */
val useCaseModule: Module = module {
    single<GetMoviesUseCase> { GetMoviesUseCase(get()) }
    single<GetPagingMoviesUseCase> { GetPagingMoviesUseCase(get()) }
    single<GetLocalMoviesUseCase> { GetLocalMoviesUseCase(get()) }
}