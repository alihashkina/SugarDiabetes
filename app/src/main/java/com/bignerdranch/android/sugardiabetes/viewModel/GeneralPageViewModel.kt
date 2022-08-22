package com.bignerdranch.android.sugardiabetes.viewModel

import android.content.ContentValues
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.sugardiabetes.R
import com.bignerdranch.android.sugardiabetes.db.MyDBHelper
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.arrayDateGraph
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.arraySugarGraph
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.chipsCheckTxt
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.dateDB
import com.google.android.material.chip.Chip
import com.madrapps.plot.line.LinePlot
import im.dacer.androidcharts.LineView
import java.text.SimpleDateFormat
import java.util.*

class GeneralPageViewModel : ViewModel() {

    companion object{
        val calendar = Calendar.getInstance()
        var year = 0
        var month = 0
        var day = 0
        var hour = 0
        var minute = 0
    }

    fun chipsCheck(chip1: Chip, chip2: Chip, chip3: Chip, chip4: Chip, chip5: Chip){
        if (chip1.isChecked) {
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip1.text.toString())){
            }else{
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip1.text.toString() + " "}"
            }
        }

        if (chip2.isChecked) {
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip2.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip2.text.toString() + " "}"
            }
        }

        if (chip3.isChecked) {
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip3.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip3.text.toString() + " "}"
            }
        }

        if (chip4.isChecked) {
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip4.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip4.text.toString() + " "}"
            }
        }

        if (chip5.isChecked) {
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip5.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip5.text.toString() + " "}"
            }
        }
    }

//    fun graph(graph: LineView){
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
//
//        var strList = arrayListOf("${MyDBHelper(context = GeneralPage(context)).}")
//        val dataLists = ArrayList<ArrayList<Int>>()
//        dataLists.add(dataList)
//
//        graph.setDrawDotLine(false) //optional
//        graph.getResources().getColor(R.color.md_white_1000)
//        graph.setShowPopup(LineView.SHOW_POPUPS_NONE) //optional
//        graph.setBottomTextList(strList)
//        graph.setColorArray(intArrayOf(R.color.md_black_1000))
//        graph.setDataList(dataLists)
//    }

    fun getDateTimeCalendar(txtRecord: TextView){
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        txtRecord.text = "Record $day.${month + 1}.$year $hour:$minute"
    }

    fun graph(graph: LineView){
        if(dateDB != "") {
            val dataLists = ArrayList<ArrayList<Int>>()
            dataLists.add(arraySugarGraph as ArrayList<Int>)
            graph.setDrawDotLine(false) //optional
            graph.getResources().getColor(R.color.md_white_1000)
            graph.setShowPopup(LineView.SHOW_POPUPS_NONE) //optional
            graph.setBottomTextList(arrayDateGraph as ArrayList<String>?)
            graph.setColorArray(intArrayOf(R.color.md_black_1000))
            graph.setDataList(dataLists)
            Log.i("LOG", "+")
        }
    }

    fun graphError(graph: LineView){
            val dataLists = ArrayList<ArrayList<Int>>()
            //dataLists.add(arraySugarGraph as ArrayList<Int>)
            graph.setDrawDotLine(false) //optional
            graph.getResources().getColor(R.color.md_white_1000)
            graph.setShowPopup(LineView.SHOW_POPUPS_NONE) //optional
            //graph.setBottomTextList(arrayDateGraph as ArrayList<String>?)
            graph.setColorArray(intArrayOf(R.color.md_black_1000))
            graph.setDataList(dataLists)
            Log.i("LOG", "-")
    }

}