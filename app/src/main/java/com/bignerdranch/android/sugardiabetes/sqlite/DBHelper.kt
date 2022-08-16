package com.bignerdranch.android.sugardiabetes.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DB.DATABASE_NAME, null, DB.DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(DB.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL(DB.SQL_DELETE_TABLE)
        onCreate(db)
    }

}