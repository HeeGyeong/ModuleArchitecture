package com.example.moviesearch.domain.usecase

import com.example.entity.entity.Movie
import com.example.moviesearch.domain.repository.MovieRepository
import io.reactivex.Flowable

/**
 * Movie Data 를 가져오기 위한 함수.
 * Repository 를 통해 선언 된 함수를 사용한다.
 *
 * @param repository Movie data 를 컨트롤 하는 Repository
 */
class GetMoviesUseCase(private val repository: MovieRepository) {
    fun execute(
        query: String
    ): Flowable<List<Movie>> = repository.getSearchMovies(query)

}