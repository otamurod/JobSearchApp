package com.otamurod.jobsearchapp.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otamurod.jobsearchapp.model.ListItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListScreenViewModel : ViewModel() {
    private lateinit var liveData: MutableLiveData<ListItemModel>

    init {
        liveData = MutableLiveData()
    }

    fun getLiveData(): MutableLiveData<ListItemModel> {
        return liveData
    }

    fun sendQuery(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //we post value to our live data when response comes successfully
            //so this process will be in IO Thread
            val jobs = ListItemModel( //this is the fake data
                arrayListOf(
                    "Android Developer",
                    "iOS Developer",
                    "Java Developer",
                    "Flutter Developer",
                    "DevOps Developer",
                    "C++ Developer"
                )
            )
            liveData.postValue(jobs)
        }
    }
}