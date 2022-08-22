package com.bignerdranch.android.sugardiabetes.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.RoomMasterTable.TABLE_NAME

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, "USERS", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, SUGAR TEXT, CHIPS TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}