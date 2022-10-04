package com.otamurod.jobsearchapp.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListScreenViewModel : ViewModel() {
    private var liveData = MutableLiveData<String>()

    init {
        liveData = // TODO: init live data
    }

    fun getLiveData(): MutableLiveData<String> {
        return liveData
    }
}