package com.bignerdranch.android.sugardiabetes.sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.sugardiabetes.R

class DBAdapter (var dataList: ArrayList<Array<String>>): RecyclerView.Adapter<DBAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var rctxtDate: TextView = itemView.findViewById(R.id.rctxtDate)
        var rctxtSugar: TextView = itemView.findViewById(R.id.rctxtSugar)
        var rctxtChips: TextView = itemView.findViewById(R.id.rctxtChips)

        fun bind(date:String, sugar:String, chips:String){
            rctxtDate.text = date
            rctxtSugar.text = sugar
            rctxtChips.text = chips
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position][position], dataList[position][position], dataList[position][position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItems(list: ArrayList<Array<String>>){
        dataList = list
        notifyDataSetChanged()
    }



}