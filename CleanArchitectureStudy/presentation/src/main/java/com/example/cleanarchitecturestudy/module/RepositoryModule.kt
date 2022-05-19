package com.example.cleanarchitecturestudy.module

import com.example.data.repository.search.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Repository 에 관련 된 Module
 *
 * 사용 가능한 3가지 방법을 모두 작성해 두었습니다.
 */
val repositoryModule: Module = module {
//    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }

    // import org.koin.core.module.dsl.bind
    /*singleOf(::MovieRepositoryImpl) {
        bind<MovieRepository>()
    }*/

    // import org.koin.dsl.bind
    singleOf(::MovieRepositoryImpl) bind MovieRepository::class
}
