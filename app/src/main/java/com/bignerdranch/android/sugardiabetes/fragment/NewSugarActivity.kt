package com.bignerdranch.android.sugardiabetes.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.editChips
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.editData
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.editSugar
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.flag
import com.bignerdranch.android.sugardiabetes.room.Sugar


class NewSugarActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
if(flag){
    val replyIntent = Intent()
    if (TextUtils.isEmpty(editSugar) && TextUtils.isEmpty(editData) && TextUtils.isEmpty(editChips)) {
        setResult(Activity.RESULT_CANCELED, replyIntent)
    } else {
        val sugar = editSugar
        val data = editData
        val chips = editChips
        replyIntent.putExtra(EXTRA_REPLY, sugar)
        replyIntent.putExtra(EXTRA_REPLY, data)
        replyIntent.putExtra(EXTRA_REPLY, chips)
        setResult(Activity.RESULT_OK, replyIntent)
        Log.i("LOG", "${sugar}")
    }
    finish()
}

        }


    companion object {
        const val EXTRA_REPLY = "com.example.android.sugarlistsql.REPLY"
    }
}