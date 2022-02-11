package com.example.local.db.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.entity.dto.MovieDTO
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Data Access Object
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieDTO>): Completable

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Single<List<MovieDTO>>

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :title || '%'")
    fun getMoviesByTitle(title: String): Single<List<MovieDTO>>

    @Query("DELETE FROM movie")
    fun deleteAllMovies(): Completable
}