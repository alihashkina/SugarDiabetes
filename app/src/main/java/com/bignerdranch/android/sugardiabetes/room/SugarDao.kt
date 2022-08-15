package com.bignerdranch.android.sugardiabetes.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SugarDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM sugar_table ORDER BY sugar ASC")
    fun getAlphabetizedSugar(): Flow<List<Sugar>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sugar: Sugar)

    @Query("DELETE FROM sugar_table")
    suspend fun deleteAll()
}