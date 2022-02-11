package com.example.local.repository.search

import com.example.entity.dto.MovieDTO
import com.example.local.db.movie.MovieDao
import io.reactivex.Completable
import io.reactivex.Single

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 *
 * @param movieDao Local movie Data 가 저장 되어있는 DB
 */
class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override fun insertMovies(movies: List<MovieDTO>): Completable =
        movieDao.insertMovies(movies)

    override fun getAllMovies(): Single<List<MovieDTO>> = movieDao.getAllMovies()

    override fun getSearchMovies(title: String): Single<List<MovieDTO>> =
        movieDao.getMoviesByTitle(title)

    override fun deleteAllMovies(): Completable = movieDao.deleteAllMovies()

}