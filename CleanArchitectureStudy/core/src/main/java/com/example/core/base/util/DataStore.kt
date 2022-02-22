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

/**
 * DataStore Class.
 *
 * Preference 가 deprecated 되면서 DataStore 를 사용 하도록 권장하고 있음.
 * 따라서, Preference 대신 사용하기 위해서 생성.
 */
class DataStore(private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "dataStore")

    // DataStore Key. 저장 할 개수에 따라서 추가적인 변수 선언이 필요하다.
    private val stringKey = stringPreferencesKey("string_key")

    // DataStore 에 저장된 값을 가져옴. 예외 처리를 위해 .catch 문이 추가되었지만, 예외처리가 필요 없으면 map 만 사용하면 된다.
    val dataStoreText: Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[stringKey] ?: "" // ?: 를 사용해 Preference 의 default value 와 동일하게 구현.
        }

    // DataStore 에 데이터를 저장함. edit 사용을 위해 해당 Method 는 suspend 선언이 필요함.
    suspend fun setDataStoreText(text: String) {
        context.dataStore.edit { preferences ->
            preferences[stringKey] = text
        }
    }
}
