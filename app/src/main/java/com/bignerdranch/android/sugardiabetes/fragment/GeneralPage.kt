package com.bignerdranch.android.sugardiabetes.fragment

import android.content.ContentValues
import android.content.Context
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
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Query
import com.bignerdranch.android.sugardiabetes.R
import com.bignerdranch.android.sugardiabetes.databinding.GeneralPageFragmentBinding
import com.bignerdranch.android.sugardiabetes.db.MyDBHelper
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel
import com.google.firebase.database.DatabaseReference
import im.dacer.androidcharts.LineView
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


class GeneralPage : Fragment() {

    companion object {
        fun newInstance() = GeneralPage()
        lateinit var bindingGeneralPage: GeneralPageFragmentBinding
        var editSugar = ""
        var editData = "10"
        var editChips = "10"
        var flag = false
        var chip1Check = false
        var chip2Check = false
        var chip3Check = false
        var chip4Check = false
        var chip5Check = false
        var chipsCheckTxt = ""
    }

    //lateinit var database : DatabaseReference

    //lateinit var adapter: DBAdapter
    private lateinit var viewModel: GeneralPageViewModel
   // val sdf = SimpleDateFormat("dd.MM.yyyy hh:mm")
//    val currentDate = sdf.format(Date())
//var currentDate = Calendar.getInstance().time
   val date = getCurrentDateTime()
    val dateInString = date.toString("dd.MM.yy HH:mm")


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
        //txtSugarConst = bindingGeneralPage.txtSugar.text.toString()

        //dbManager = DBManager(context!!)
        //DBManager(context!!).openDb()


bindingGeneralPage.txtRecord.text = "Record ${dateInString}"


        editSugar = bindingGeneralPage.txtSugar.text.toString()
        bindingGeneralPage.txtSugar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(bindingGeneralPage.txtSugar.text.toString().toDouble() == -0.0){
                    bindingGeneralPage.txtSugar.setText("0.0")
                }
                if(bindingGeneralPage.txtSugar.text.toString().toDouble() > 30){
                    bindingGeneralPage.txtSugar.setText("30.0")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        if(bindingGeneralPage.txtSugar.text.toString().toDouble() < 30.0)
            bindingGeneralPage.btnPlus.setOnClickListener {
                bindingGeneralPage.txtSugar.setText("${bindingGeneralPage.txtSugar.text.toString().toDouble() + 0.1}")
                Log.i("LOG", "++++")
            }


        if(bindingGeneralPage.txtSugar.text.toString().toDouble() != 0.0)
            bindingGeneralPage.btnMinus.setOnClickListener{
                bindingGeneralPage.txtSugar.setText("${bindingGeneralPage.txtSugar.text.toString().toDouble() - 0.1}")
                Log.i("LOG", "----")
            }

//        var database = Firebase.database

//        bindingGeneralPage.btnSave.setOnClickListener {
//var sugar = bindingGeneralPage.txtSugar.text.toString().toDouble()
//
//             database = FirebaseDatabase.getInstance().getReference("Date")
//            var date = Date(sugar)
////            database.child(sugar).setValue(date).addOnCanceledListener {
////
////            }
//        }

        bindingGeneralPage.btnSave.setOnClickListener {
//            val myRef = database.getReference("date")
//            //database.getReference("date").setValue("${bindingGeneralPage.txtSugar.text}")
//            bindingGeneralPage.txtSugar.setText(database.getReference("date").toString())
//            RoomDBViewModel(DatabaseHelperImpl(DatabaseBuilder.getInstance(context!!))).fetchUsers()
//            RoomDBViewModel(DatabaseHelperImpl(DatabaseBuilder.getInstance(context!!))).getUsers()

//            DBManager(context!!).insertToDb("10.08.2022", bindingGeneralPage.txtSugar.text.toString(), "good")
//            adapter = DBAdapter(DBManager(context!!).readDbData())
//            bindingGeneralPage.recyclerView.layoutManager = LinearLayoutManager(context!!)
//            bindingGeneralPage.recyclerView.adapter = adapter
//            adapter.setItems(DBManager(context!!).readDbData())
//           // requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, AddingSugar.newInstance()).addToBackStack(null).commit()

            viewModel.chipsCheck()
            var cv = ContentValues()
            cv.put("DATE", "${dateInString}")
            cv.put("SUGAR", bindingGeneralPage.txtSugar.text.toString())
            cv.put("CHIPS", "${chipsCheckTxt}")
            MyDBHelper(context!!).readableDatabase.insert("USERS", null, cv)
            Log.i("LOG", "${chipsCheckTxt}")
            chipsCheckTxt = ""
        }


//
//
//        myRef.addValueEventListener(object: ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val value = snapshot.getValue()
//                Log.d(TAG, "Value is: " + value)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Log.w(TAG, "Failed to read value.", error.toException())
//            }
//
//        })

//       val series = LineGraphSeries(
//            arrayOf<DataPoint>(
//                DataPoint(0.0, 1.0),
//                DataPoint(1.0, 5.0),
//                DataPoint(2.0, 3.0),
//                DataPoint(3.0, 2.0),
//                DataPoint(4.0, 6.0),
//                DataPoint(14.0, 16.0),
//                DataPoint(24.0, 26.0)
//
//            )
//        )
//        bindingGeneralPage.graphView.addSeries(series)

//        val filter: InputFilter = object : InputFilter {
//            val maxDigitsBeforeDecimalPoint = 4
//            val maxDigitsAfterDecimalPoint = 1
//            override fun filter(
//                source: CharSequence, start: Int, end: Int,
//                dest: Spanned, dstart: Int, dend: Int
//            ): CharSequence {
//                val builder = StringBuilder(dest)
//                builder.replace(
//                    dstart, dend, source
//                        .subSequence(start, end).toString()
//                )
//                return if (!builder.toString().matches(
//                        "(([1-9]{1})([0-9]{0," + (maxDigitsBeforeDecimalPoint - 1) + "})?)?(\\.[0-9]{0," + maxDigitsAfterDecimalPoint + "})?"
//                    )
//                ) {
//                    if (source.length == 0) dest.subSequence(dstart, dend) else ""
//                } else null
//            }
//        }
//
//        bindingGeneralPage.txtSugar.setFilters(arrayOf(filter))

        val dataList = ArrayList<Int>()
        var random = (Math.random() * 9 + 1).toFloat()
        //for (i in 3 until random.toInt()) {
        dataList.add(5)
        dataList.add(15)
        dataList.add(3)
        dataList.add(23)
        dataList.add(8)
        dataList.add(4)
        dataList.add(17)
        dataList.add(9)
        dataList.add(12)
        dataList.add(0)
        //}




        var strList = arrayListOf("01.08", "02.08", "03.08", "04.08", "05.08", "06.08", "07.08", "08.08", "09.08", "10.08")
        val dataLists = ArrayList<ArrayList<Int>>()
        dataLists.add(dataList)

        var graph: LineView = view!!.findViewById(R.id.graph)
        graph.setDrawDotLine(false) //optional
        graph.getResources().getColor(R.color.md_white_1000)
        graph.setShowPopup(LineView.SHOW_POPUPS_NONE) //optional
        graph.setBottomTextList(strList)
        graph.setColorArray(intArrayOf(R.color.md_black_1000))
        graph.setDataList(dataLists)
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}