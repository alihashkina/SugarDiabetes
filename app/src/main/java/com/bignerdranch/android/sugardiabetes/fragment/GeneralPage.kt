package com.bignerdranch.android.sugardiabetes.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.sugardiabetes.R
import com.bignerdranch.android.sugardiabetes.viewModel.GeneralPageViewModel

class GeneralPage : Fragment() {

    companion object {
        fun newInstance() = GeneralPage()
    }

    private lateinit var viewModel: GeneralPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.general_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GeneralPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}