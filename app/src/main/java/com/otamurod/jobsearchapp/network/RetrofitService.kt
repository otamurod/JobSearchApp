package com.otamurod.apicallusingmvvmcoroutines.network

import com.otamurod.jobsearchapp.model.ListItemModel
import retrofit2.http.GET

interface RetrofitService {
    @GET(value = "")
    suspend fun getDataFromAPI(): ListItemModel
}