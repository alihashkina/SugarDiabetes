package com.bignerdranch.android.sugardiabetes.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class SugarRepository(private val sugarDao: SugarDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allSugar: Flow<List<Sugar>> = sugarDao.getAlphabetizedSugar()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(sugar: Sugar) {
        sugarDao.insert(sugar)
    }
}
