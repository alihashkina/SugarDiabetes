package com.bignerdranch.android.sugardiabetes.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, "USERS", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, SUGAR TEXT, CHIPS TEXT)")
//        db?.execSQL("INSERT INTO USERS(DATE, SUGAR, CHIPS) VALUES ('10.05.2022', '1.5', 'GOOD')")
//        db?.execSQL("INSERT INTO USERS(DATE, SUGAR, CHIPS) VALUES ('10.12.2022', '8.5', 'BAD')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}