package com.example.core.base.util

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStore(private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "dataStore")
    private val stringKey = stringPreferencesKey("string_key") // DataStore Key

    // DataStore 에 저장된 값을 가져옴.
    val dataStoreText: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[stringKey] ?: ""
        }

    // DataStore 에 데이터를 저장함.
    suspend fun setDataStoreText(text: String) {
        context.dataStore.edit { preferences ->
            preferences[stringKey] = text
        }
    }
}

