package com.bignerdranch.android.sugardiabetes.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.*
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Query
import com.bignerdranch.android.sugardiabetes.MainActivity
import com.bignerdranch.android.sugardiabetes.R
import com.bignerdranch.android.sugardiabetes.databinding.GeneralPageFragmentBinding
import com.bignerdranch.android.sugardiabetes.db.MyDBHelper
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel.Companion.day
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel.Companion.hour
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel.Companion.minute
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel.Companion.month
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel.Companion.year
import com.google.firebase.database.DatabaseReference
import im.dacer.androidcharts.LineView
import kotlinx.coroutines.flow.Flow
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.math.min
import kotlin.math.roundToInt


class GeneralPage : Fragment(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    companion object {
        fun newInstance() = GeneralPage()
        lateinit var bindingGeneralPage: GeneralPageFragmentBinding
        var editSugar = ""
        var chipsCheckTxt = ""
        var dateDB = ""
        var arrayDateGraph : MutableList<String> = mutableListOf()
        var arraySugarGraph : MutableList<Int> = mutableListOf()
    }

    var saveyear = 0
    var savemonth = 0
    var saveday = 0
    var savehour = 0
    var saveminute = 0


    private lateinit var viewModel: GeneralPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingGeneralPage= DataBindingUtil.inflate(inflater, R.layout.general_page_fragment,container,false)
        return bindingGeneralPage.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GeneralPageViewModel::class.java)

//        bindingGeneralPage.txtRecord.text = "Record ${dateInString}"



        editSugar = bindingGeneralPage.txtSugar.text.toString()
//        bindingGeneralPage.txtSugar.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//                if(bindingGeneralPage.txtSugar.text.toString().toDouble() < 0.0 ){
//                    bindingGeneralPage.txtSugar.setText("0.0")
//                }
//                if(bindingGeneralPage.txtSugar.text.toString().toDouble() > 30){
//                    bindingGeneralPage.txtSugar.setText("30.0")
//                }
//            }
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })


            bindingGeneralPage.btnPlus.setOnClickListener {
                if(bindingGeneralPage.txtSugar.text.toString().toDouble() < 30.0) {
                bindingGeneralPage.txtSugar.setText(
                    "${
                        bindingGeneralPage.txtSugar.text.toString().toDouble() + 0.1
                    }"
                )
                Log.i("LOG", "++++")
            }
        else{
            bindingGeneralPage.txtSugar.setText("30.0")
        }
    }
        bindingGeneralPage.btnMinus.setOnClickListener {
        if(bindingGeneralPage.txtSugar.text.toString().toDouble() != 0.0) {
                bindingGeneralPage.txtSugar.setText(
                    "${
                        bindingGeneralPage.txtSugar.text.toString().toDouble() - 0.1
                    }"
                )
                Log.i("LOG", "----")
            }
        else{
            bindingGeneralPage.txtSugar.setText("0.0")
        }
        }

//        var helper = MyDBHelper(context!!)
//        var db = helper.readableDatabase
//        var rs = db.rawQuery("SELECT DATE, SUGAR, CHIPS FROM USERS", null)
//
//
//        while (rs.moveToNext()) {
//            //  Toast.makeText(applicationContext, rs.getString(2).get(1), Toast.LENGTH_LONG).show()
//            dateDB = rs.getString(0)
//           var sugarDB = rs.getString(1).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
//            rs.getString(2)
//            arrayDateGraph.add(dateDB)
//            arraySugarGraph.add(sugarDB.toInt())
//            Log.i("LOG", "${arrayDateGraph}")
//        }

//        val dataList = ArrayList<Int>()
//        dataList.add(5)
//        dataList.add(15)
//        dataList.add(3)
//        dataList.add(23)
//        dataList.add(8)
//        dataList.add(4)
//        dataList.add(17)
//        dataList.add(9)
//        dataList.add(12)
//        dataList.add(0)


        viewModel.graph(bindingGeneralPage.graph)

        bindingGeneralPage.btnSave.setOnClickListener {

            viewModel.chipsCheck(bindingGeneralPage.chip1, bindingGeneralPage.chip2, bindingGeneralPage.chip3, bindingGeneralPage.chip4, bindingGeneralPage.chip5)

            var cv = ContentValues()
            cv.put("DATE", "${bindingGeneralPage.txtRecord.text.drop(7)}")
            cv.put("SUGAR", GeneralPage.bindingGeneralPage.txtSugar.text.toString())
            cv.put("CHIPS", "${chipsCheckTxt}")
            MyDBHelper(context!!).readableDatabase.insert("USERS", null, cv)
            // Log.i("LOG", "${arrayDateGraph}")
            //Log.i("LOG", "${bindingGeneralPage.txtRecord.text}")
            chipsCheckTxt = ""

            var helper = MyDBHelper(context!!)
            var db = helper.readableDatabase
            var rs = db.rawQuery("SELECT DATE, SUGAR, CHIPS FROM USERS", null)


            while (rs.moveToNext()) {
                //  Toast.makeText(applicationContext, rs.getString(2).get(1), Toast.LENGTH_LONG).show()
                dateDB = rs.getString(0)
                var sugarDB = rs.getString(1).toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()
                rs.getString(2)
                arrayDateGraph.add(dateDB)
                arraySugarGraph.add(sugarDB.toInt())
                Log.i("LOG", "${arrayDateGraph}")
            }

            viewModel.graph(bindingGeneralPage.graph)
        }

        if(bindingGeneralPage.txtRecord.text == ""){
            viewModel.getDateTimeCalendar(bindingGeneralPage.txtRecord)
        }

        pickDate()
    }



    private fun pickDate(){
        bindingGeneralPage.txtRecord.setOnClickListener{
            viewModel.getDateTimeCalendar(bindingGeneralPage.txtRecord)
            DatePickerDialog(context!!, this, year, month, day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        saveday = day
        savemonth = month
        saveyear = year
        viewModel.getDateTimeCalendar(bindingGeneralPage.txtRecord)
        TimePickerDialog(context!!, this, hour, minute, false).show()
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        savehour = hour
        saveminute = minute
        bindingGeneralPage.txtRecord.text = "Record $saveday.${savemonth + 1}.$saveyear $savehour:$saveminute"
    }

    override fun onResume() {
        super.onResume()

    }

}