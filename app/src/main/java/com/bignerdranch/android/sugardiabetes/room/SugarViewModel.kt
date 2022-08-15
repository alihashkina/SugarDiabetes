package com.bignerdranch.android.sugardiabetes.room

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class SugarViewModel(private val repository: SugarRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allSugar: LiveData<List<Sugar>> = repository.allSugar.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(sugar: Sugar) = viewModelScope.launch {
        repository.insert(sugar)
    }
}

class SugarViewModelFactory(private val repository: SugarRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SugarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SugarViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
