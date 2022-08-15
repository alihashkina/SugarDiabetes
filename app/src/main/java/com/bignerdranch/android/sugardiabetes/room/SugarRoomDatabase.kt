package com.bignerdranch.android.sugardiabetes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Sugar::class], version = 1)
abstract class SugarRoomDatabase : RoomDatabase() {

    abstract fun sugarDao(): SugarDao

    companion object {
        @Volatile
        private var INSTANCE: SugarRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): SugarRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SugarRoomDatabase::class.java,
                    "sugar_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(SugarDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class SugarDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.sugarDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(sugarDao: SugarDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            sugarDao.deleteAll()

            var sugar = Sugar(1,"15.08.2022", "7.3", "good")
            sugarDao.insert(sugar)
//            sugar = Sugar("World!")
//            sugarDao.insert(sugar)
        }
    }
}
