package com.example.moviesearch.domain.repository

import com.example.entity.entity.Movie
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * UseCase 에 필요한 Interface 를 선한한 Repository.
 * RepositoryImpl 에서 구현되며, 실제 필요한 데이터를 가져온다.
 */
interface MovieRepository {
    fun getSearchMovies(
        query: String
    ): Flowable<List<Movie>>

    fun getLocalSearchMovies(
        query: String
    ): Flowable<List<Movie>>

    fun getRemoteSearchMovies(
        query: String
    ): Single<List<Movie>>

    fun getPagingMovies(
        query: String,
        offset: Int
    ): Single<List<Movie>>
}