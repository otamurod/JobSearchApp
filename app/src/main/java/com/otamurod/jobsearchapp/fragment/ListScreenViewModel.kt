package com.otamurod.jobsearchapp.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListScreenViewModel : ViewModel() {
    private lateinit var liveData: MutableLiveData<String>

    init {
        liveData = MutableLiveData()
    }

    fun getLiveData(): MutableLiveData<String> {
        return liveData
    }
}