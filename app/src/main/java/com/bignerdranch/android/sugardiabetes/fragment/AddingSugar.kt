package com.bignerdranch.android.sugardiabetes.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.sugardiabetes.R
import com.bignerdranch.android.sugardiabetes.databinding.AddingSugarFragmentBinding
import com.bignerdranch.android.sugardiabetes.databinding.GeneralPageFragmentBinding
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.dbManager
import com.bignerdranch.android.sugardiabetes.sqlite.DBAdapter
import com.bignerdranch.android.sugardiabetes.viewModel.AddingSugarViewModel

class AddingSugar : Fragment() {

    companion object {
        fun newInstance() = AddingSugar()
    }
    lateinit var bindingAddingSugar: AddingSugarFragmentBinding
    private lateinit var viewModel: AddingSugarViewModel
    lateinit var adapter: DBAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAddingSugar = DataBindingUtil.inflate(inflater, R.layout.adding_sugar_fragment,container,false)
        return bindingAddingSugar.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddingSugarViewModel::class.java)
        // TODO: Use the ViewModel

     adapter = DBAdapter(dbManager.readDbData())
       bindingAddingSugar.recyclerView.layoutManager = LinearLayoutManager(context!!)
        bindingAddingSugar.recyclerView.adapter = adapter
        adapter.setItems(dbManager.readDbData())

bindingAddingSugar.button2.setOnClickListener{
    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()

}
    }

}