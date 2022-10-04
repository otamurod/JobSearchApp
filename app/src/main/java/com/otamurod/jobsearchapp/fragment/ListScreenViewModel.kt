package com.otamurod.jobsearchapp.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otamurod.apicallusingmvvmcoroutines.network.RetrofitInstance
import com.otamurod.apicallusingmvvmcoroutines.network.RetrofitService
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
            val retrofitService =
                RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
            val response = retrofitService.getDataFromAPI()
            liveData.postValue(response)

        }
    }
}