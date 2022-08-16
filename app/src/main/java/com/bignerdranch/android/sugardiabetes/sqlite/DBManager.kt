package com.bignerdranch.android.sugardiabetes.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBManager (context: Context){
    val dbHelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = dbHelper.writableDatabase
    }

    fun insertToDb(date: String, sugar: String, chips: String){
        val values = ContentValues().apply {
            put(DB.DATE, date)
            put(DB.SUGAR, sugar)
            put(DB.CHIPS, chips)
        }


        db?.insert(DB.TABLE_NAME, null ,values)
    }

    fun readDbData(): ArrayList<Array<String>>{
        val dataList = ArrayList<Array<String>>()
        val cursor = db?.query(DB.TABLE_NAME, null, null, null, null, null, null)

        while (cursor?.moveToNext() != null && cursor.moveToNext()) {
            val dataText = cursor.getString(cursor.getColumnIndex(DB.DATE))
            val sugarText = cursor.getString(cursor.getColumnIndex(DB.SUGAR))
                val chipsText = cursor.getString(cursor.getColumnIndex(DB.CHIPS))
            dataList.add(arrayOf(dataText.toString(), sugarText.toString(), chipsText.toString()))
        }

        cursor?.close()
        return dataList
    }

    fun closeDb(){
        dbHelper.close()
    }
}