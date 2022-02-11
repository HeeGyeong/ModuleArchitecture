package com.example.api.repository

import com.example.api.api.ApiInterface
import com.example.entity.dto.MovieResponse
import io.reactivex.Single

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 *
 * @param apiInterface api 호출을 위한 Interface
 */
class MovieRemoteDataSourceImpl(private val apiInterface: ApiInterface) :
    MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): Single<MovieResponse> {
        return apiInterface.getSearchMovie(query, start)
    }

}