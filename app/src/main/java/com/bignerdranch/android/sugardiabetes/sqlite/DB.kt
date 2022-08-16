package com.bignerdranch.android.sugardiabetes.sqlite

import android.provider.BaseColumns

object DB: BaseColumns {
    const val TABLE_NAME = "my_table"
    const val DATE = "date"
    const val SUGAR = "sugar"
    const val CHIPS = "chips"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyDb.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $DATE TEXT, $SUGAR TEXT, $CHIPS TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"



}