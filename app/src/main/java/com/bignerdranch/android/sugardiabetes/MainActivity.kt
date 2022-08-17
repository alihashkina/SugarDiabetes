package com.bignerdranch.android.sugardiabetes

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import com.bignerdranch.android.sugardiabetes.db.MyDBHelper
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.editChips
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.editData
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.editSugar
import com.bignerdranch.android.sugardiabetes.fragment.NewSugarActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {

    companion object{
        // lateinit var menu: BottomNavigationView
    }
//    private val sugarViewModel: SugarViewModel by viewModels {
//        SugarViewModelFactory((application as SugarApplication).repository)
//    }



    private val newSugarActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        menu = findViewById(R.id.menu)
//        menu.setOnNavigationItemSelectedListener {
//                item ->
//            when (item.itemId) {
//                R.id.generalPage -> {
//                   // supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsAll.newInstance()).addToBackStack(null).commit()
//                }
//                R.id.calendar -> {
//                   // supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
//                }
//                R.id.statistic -> {
//                   // supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
//                }
//                R.id.setting -> {
//                    // supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
//                }
//
//            }
//            true
//        }


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

//        sugarViewModel.allSugar.observe(owner = this) { sugar ->
//            // Update the cached copy of the words in the adapter.
//            sugar.let { adapter.submitList(it) }
//        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
//        super.onActivityResult(requestCode, resultCode, intentData)
//
//        if (requestCode == newSugarActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            intentData?.getStringExtra(NewSugarActivity.EXTRA_REPLY)?.let { reply ->
//                val word = Word(reply)
//                wordViewModel.insert(word)
//            }
//        } else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
//override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
//    super.onActivityResult(requestCode, resultCode, intentData)
//
//    if (requestCode == newSugarActivityRequestCode && resultCode == Activity.RESULT_OK) {
//        intentData?.getStringExtra(NewSugarActivity.EXTRA_REPLY)?.let { reply ->
//            val sugar = Sugar(1, editData, editSugar, editChips)
//            sugarViewModel.insert(sugar)
//            Log.i("LOG", "${sugar}")
//        }
//    }
//
//}
//    override fun onDestroy() {
//        super.onDestroy()
//        //DBManager().closeDb()
//    }
}