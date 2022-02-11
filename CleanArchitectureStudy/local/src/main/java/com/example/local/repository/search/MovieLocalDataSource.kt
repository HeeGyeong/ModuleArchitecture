package com.example.local.repository.search

import com.example.entity.dto.MovieDTO
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Local 에 저장되어 있는 Movie Data 를 사용하기 위한 interface
 * DataSourceImpl 에서 구현된다.
 */
interface MovieLocalDataSource {
    fun insertMovies(movies: List<MovieDTO>): Completable
    fun getAllMovies(): Single<List<MovieDTO>>
    fun getSearchMovies(title: String): Single<List<MovieDTO>>
    fun deleteAllMovies(): Completable
}