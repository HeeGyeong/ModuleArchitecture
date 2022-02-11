package com.example.api.repository

import com.example.entity.dto.MovieResponse
import io.reactivex.Single

/**
 * Api 호출을 통해 Movie Data 를 가져오기 위한 interface
 * DataSourceImpl 에서 구현된다.
 */
interface MovieRemoteDataSource {
    fun getSearchMovies(
        query: String,
        start: Int = 1
    ): Single<MovieResponse>
}