package com.bignerdranch.android.sugardiabetes.viewModel

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage
import com.bignerdranch.android.sugardiabetes.fragment.GeneralPage.Companion.chipsCheckTxt

class GeneralPageViewModel : ViewModel() {


    fun chipsCheck(){
        if (GeneralPage.bindingGeneralPage.chip1.isChecked) {
            GeneralPage.chip1Check = true
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip1.text.toString())){
            }else{
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip1.text.toString() + " "}"
            }

        }

        if (GeneralPage.bindingGeneralPage.chip2.isChecked) {
            GeneralPage.chip2Check = true
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip2.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip2.text.toString() + " "}"
            }
        }

        if (GeneralPage.bindingGeneralPage.chip3.isChecked) {
            GeneralPage.chip3Check = true
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip3.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip3.text.toString() + " "}"
            }
        }

        if (GeneralPage.bindingGeneralPage.chip4.isChecked) {
            GeneralPage.chip4Check = true
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip4.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip4.text.toString() + " "}"
            }
        }

        if (GeneralPage.bindingGeneralPage.chip5.isChecked) {
            GeneralPage.chip5Check = true
            if(chipsCheckTxt.contains(GeneralPage.bindingGeneralPage.chip5.text.toString())){
            }else {
                chipsCheckTxt = chipsCheckTxt + "${GeneralPage.bindingGeneralPage.chip5.text.toString() + " "}"
            }
        }
    }
}