package com.bignerdranch.android.sugardiabetes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.bignerdranch.android.sugardiabetes.db.MyDBHelper
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.bindingGeneralPage
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

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)

        if(rs.moveToNext()) {
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()
        }

    }
}