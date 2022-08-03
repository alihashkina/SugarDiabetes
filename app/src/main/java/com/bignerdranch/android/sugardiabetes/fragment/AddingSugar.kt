package com.bignerdranch.android.sugardiabetes.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.sugardiabetes.R
import com.bignerdranch.android.sugardiabetes.viewModel.AddingSugarViewModel

class AddingSugar : Fragment() {

    companion object {
        fun newInstance() = AddingSugar()
    }

    private lateinit var viewModel: AddingSugarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.adding_sugar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddingSugarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}