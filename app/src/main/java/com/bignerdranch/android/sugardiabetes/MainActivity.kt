package com.bignerdranch.android.sugardiabetes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.bignerdranch.android.sugardiabetes.db.MyDBHelper
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.bindingGeneralPage
import java.sql.Types.DATE
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            supportFragmentManager.beginTransaction()
                .add(R.id.containerView, GeneralPage.newInstance())
                .addToBackStack(null)
                .commit()
        }

//        var helper = MyDBHelper(applicationContext)
//        var db = helper.readableDatabase
//        var rs = db.rawQuery("SELECT DATE, SUGAR, CHIPS FROM USERS", null)
//
//        while (rs.moveToNext()) {
//          //  Toast.makeText(applicationContext, rs.getString(2).get(1), Toast.LENGTH_LONG).show()
//            dateDB = rs.getString(0)
//            rs.getString(1)
//            rs.getString(2)
//            arrayDateGraph?.add(dateDB)
//            Log.i("LOG", "${arrayDateGraph}")
//        }

//        rs!!.moveToFirst()
//        Date.append(rs.getString(rs.getColumnIndex(helper.DATE)) + "\n")
//        Age.append(rs.getString(rs.getColumnIndex(DBHelper.AGE_COL)) + "\n")
//
//        // moving our cursor to next
//        // position and appending values
//        while(rs.moveToNext()){
//            Name.append(rs.getString(rs.getColumnIndex(DBHelper.NAME_COl)) + "\n")
//            Age.append(rs.getString(rs.getColumnIndex(DBHelper.AGE_COL)) + "\n")
//        }

 //arrayDateGraph = arrayOf(rs.getColumnIndex("DATE"))
    }
}