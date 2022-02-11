package com.example.local.db.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.entity.dto.MovieDTO

/**
 * Room DB
 * DB 의 column 은 MovieEntity 로 설정.
 */
@Database(entities = [MovieDTO::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}