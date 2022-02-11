package com.example.di.module

import androidx.room.Room
import com.example.local.db.movie.MovieDao
import com.example.local.db.movie.MovieDatabase
import com.example.local.repository.search.MovieLocalDataSource
import com.example.local.repository.search.MovieLocalDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Local Data 사용에 관련 된 Module.
 *
 * Room 에 대한 선언도 이곳에서 처리한다.
 */
val localDataModule: Module = module {
    single<MovieLocalDataSource> { MovieLocalDataSourceImpl(get()) }
    single { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            get(),
            MovieDatabase::class.java,
            "Movie.db"
        ).build()
    }
}